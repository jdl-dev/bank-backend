package com.app.bankbackend.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

//basic application exception
@Getter
public abstract class ApiException extends RuntimeException {

    private final String code;
    private final HttpStatus httpStatus;

    public ApiException(String code, HttpStatus httpStatus, String message) {
        super(message);
        this.code = code;
        this.httpStatus  = httpStatus;
    }
}