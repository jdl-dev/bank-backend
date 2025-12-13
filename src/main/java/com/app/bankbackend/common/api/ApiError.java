package com.app.bankbackend.common.api;

import java.time.Instant;
import java.util.List;

public record ApiError (
        Instant timestamp,
        int status,
        String error,
        String code,
        String message,
        String path,
        String traceId,
        List<FieldViolation> fieldErrors
) {
    public static ApiError of(
            int status,
            String error,
            String code,
            String message,
            String path,
            String traceId,
            List<FieldViolation> fieldErrors
    ) {
        return new ApiError(
                Instant.now(),
                status,
                error,
                code,
                message,
                path,
                traceId,
                fieldErrors);
    }
}