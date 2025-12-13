package com.app.bankbackend.auth.service;

import com.app.bankbackend.auth.api.dto.AuthResponse;
import com.app.bankbackend.auth.api.dto.LoginRequest;
import com.app.bankbackend.auth.api.dto.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request) ;
    AuthResponse login(LoginRequest request);
}