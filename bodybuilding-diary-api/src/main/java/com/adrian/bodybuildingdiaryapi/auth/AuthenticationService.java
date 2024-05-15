package com.adrian.bodybuildingdiaryapi.auth;

import com.adrian.bodybuildingdiaryapi.email.EmailService;
import com.adrian.bodybuildingdiaryapi.exception.ExpiredTokenException;
import com.adrian.bodybuildingdiaryapi.exception.InvalidTokenException;
import com.adrian.bodybuildingdiaryapi.exception.RoleDoesntExistException;
import com.adrian.bodybuildingdiaryapi.exception.UserAlreadyExistsException;
import com.adrian.bodybuildingdiaryapi.role.Role;
import com.adrian.bodybuildingdiaryapi.role.RoleRepository;
import com.adrian.bodybuildingdiaryapi.security.JwtService;
import com.adrian.bodybuildingdiaryapi.user.Token;
import com.adrian.bodybuildingdiaryapi.user.TokenRepository;
import com.adrian.bodybuildingdiaryapi.user.User;
import com.adrian.bodybuildingdiaryapi.user.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static com.adrian.bodybuildingdiaryapi.email.EmailTemplateName.ACTIVATE_ACCOUNT;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;

    public void register(RegistrationRequest request)
            throws MessagingException, UserAlreadyExistsException, RoleDoesntExistException {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RoleDoesntExistException("USER"));
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
    }

    private String generateAndSaveActivationToken(User user) {
        // generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((User)auth.getPrincipal());
        claims.put("fullName", user.fullName());
        var jwt = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder().
                token(jwt).build();
    }

    public void activateAccount(String token) throws MessagingException, InvalidTokenException, ExpiredTokenException {
        Token savedToken = tokenRepository.findByToken(token)
                .orElseThrow(InvalidTokenException::new);
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new ExpiredTokenException();
        }
        var user = userRepository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("Couldn't find user " + savedToken.getUser().getUsername()));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }
}
