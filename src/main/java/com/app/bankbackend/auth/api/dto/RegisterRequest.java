package com.app.bankbackend.auth.api.dto;

import jakarta.validation.constraints.*;

public record RegisterRequest(

        @NotBlank(message = "Email is required")
        @Email(message = "Emial must be valid")
        @Size(max = 255, message = "Email is too long")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 72, message = "Password length must be 8 - 72")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
                message = "Password must contain: lowercase, uppercase, digit"
        )
        String password,

        @NotBlank(message = "Confirm password is required")
        String confirmPassword
)
{
    @AssertTrue(message = "Passwords do not match")
    public boolean isPasswordsMatching(){
        return password != null && password.equals(confirmPassword);
    }
}