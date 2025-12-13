package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class RefreshTokenExpiredException extends ApiException {
    public RefreshTokenExpiredException() {
        super("AUTH_REFRESH_TOKEN_EXPIRED", HttpStatus.UNAUTHORIZED,
                "Refresh token has expired");
    }
}