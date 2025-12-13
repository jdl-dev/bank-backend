package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class RefreshTokenRevokedException extends ApiException {
    public RefreshTokenRevokedException() {
        super(
                "AUTH_REFRESH_TOKEN_REVOKED",
                HttpStatus.UNAUTHORIZED,
                "Refresh token has been revoked"
        );
    }
}