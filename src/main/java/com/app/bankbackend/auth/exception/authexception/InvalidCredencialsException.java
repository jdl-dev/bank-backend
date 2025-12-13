package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class InvalidCredencialsException extends ApiException {
    public InvalidCredencialsException() {
        super(
                "AUTH_INVALID_CREDENCIALS",
                HttpStatus.UNAUTHORIZED,
                "Invalid email or password"
        );
    }
}