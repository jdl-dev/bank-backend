package com.app.bankbackend.auth.service;

import com.app.bankbackend.auth.api.dto.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request) ;
}