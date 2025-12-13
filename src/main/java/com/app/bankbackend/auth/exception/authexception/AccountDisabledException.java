package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class AccountDisabledException extends ApiException {
    public AccountDisabledException() {
        super(
                "AUTH_ACCOUNT_DISABLED",
                HttpStatus.FORBIDDEN,
                "Account is disabled"
        );
    }
}