package com.app.bankbackend.common.api;

public record FieldViolation(
        String field,
        String message
) {}