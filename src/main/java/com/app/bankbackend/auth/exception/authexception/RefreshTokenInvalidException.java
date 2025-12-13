package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class RefreshTokenInvalidException extends ApiException {
    public RefreshTokenInvalidException() {
        super("AUTH_REFRESH_TOKEN_INVALID", HttpStatus.UNAUTHORIZED,
                "Refresh token is invalid");
    }
}