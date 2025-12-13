package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class EmailAlreadyUsedException extends ApiException {
    public EmailAlreadyUsedException(String email) {
        super(
                "AUTH_EMAIL_ALREADY_USED",
                HttpStatus.CONFLICT,
                "Email is already in use: " + email
        );
    }
}