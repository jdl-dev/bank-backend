package com.app.bankbackend.auth.exception.authexception;

import com.app.bankbackend.auth.exception.ApiException;
import org.springframework.http.HttpStatus;

public class AccountLockedException extends ApiException {
    public AccountLockedException() {
        super(
                "AUTH_ACCOUNT_LOCKED",
                HttpStatus.FORBIDDEN,
                "Account is locked"
        );
    }
}