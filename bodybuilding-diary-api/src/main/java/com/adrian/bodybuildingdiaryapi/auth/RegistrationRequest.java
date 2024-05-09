package com.adrian.bodybuildingdiaryapi.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegistrationRequest(

        @NotEmpty(message = "First name is required")
        @NotBlank(message = "First name is required")
        String firstName,
        @NotEmpty(message = "Last name is required")
        @NotBlank(message = "Last name is required")
        String lastName,
        @NotEmpty(message = "Email name is required")
        @NotBlank(message = "Email name is required")
        @Email(message = "Email is not formatted")
        String email,
        @NotEmpty(message = "Password name is required")
        @NotBlank(message = "Password name is required")
        @Size(min = 8, message = "Password should be 8 characters long minimum")
        String password
) {
}
