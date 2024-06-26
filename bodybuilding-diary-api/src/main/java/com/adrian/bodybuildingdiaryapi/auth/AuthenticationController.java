package com.adrian.bodybuildingdiaryapi.auth;

import com.adrian.bodybuildingdiaryapi.exception.ExpiredTokenException;
import com.adrian.bodybuildingdiaryapi.exception.InvalidTokenException;
import com.adrian.bodybuildingdiaryapi.exception.RoleDoesntExistException;
import com.adrian.bodybuildingdiaryapi.exception.UserAlreadyExistsException;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException, UserAlreadyExistsException, RoleDoesntExistException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PatchMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException, InvalidTokenException, ExpiredTokenException {
        service.activateAccount(token);
    }
}
