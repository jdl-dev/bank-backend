package com.app.bankbackend.common.api;

import com.app.bankbackend.auth.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

// 1) Walidacja @Valid na @RequestBody (rekordy DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        List<FieldViolation> fields = ex.getBindingResult().getFieldErrors().stream()
                .map(this::toViolation)
                .toList();

        ApiError body = ApiError.of(
                400,
                "Bad Request",
                "VALIDATION_ERROR",
                "Request validation failed",
                request.getRequestURI(),
                null,
                fields
        );

        return ResponseEntity.badRequest().body(body);
    }

    // 2) Wyjątki aplikacyjne (np. AUTH_INVALID_CREDENTIALS)
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiException(
            ApiException ex,
            HttpServletRequest request
    ) {
        var status = ex.getHttpStatus();

        ApiError body = ApiError.of(
                status.value(),
                status.getReasonPhrase(),
                ex.getCode(),
                ex.getMessage(),
                request.getRequestURI(),
                null,
                List.of()
        );

        return ResponseEntity.status(status).body(body);
    }

    // 3) Awaryjnie: wszystko inne → 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpected(
            Exception ex,
            HttpServletRequest request
    ) {
        ApiError body = ApiError.of(
                500,
                "Internal Server Error",
                "INTERNAL_ERROR",
                "Unexpected error occurred",
                request.getRequestURI(),
                null,
                List.of()
        );

        return ResponseEntity.internalServerError().body(body);
    }

    private FieldViolation toViolation(FieldError fe) {
        return new FieldViolation(fe.getField(), fe.getDefaultMessage());
    }
}