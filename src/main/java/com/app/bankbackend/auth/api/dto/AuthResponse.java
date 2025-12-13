package com.app.bankbackend.auth.api.dto;

public record AuthResponse(String accessToken, String refreshToken, long expiresInSeconds) {
}
