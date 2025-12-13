package com.app.bankbackend.auth.service;

import com.app.bankbackend.auth.api.dto.RegisterRequest;
import com.app.bankbackend.auth.exception.authexception.EmailAlreadyUsedException;
import com.app.bankbackend.domain.User;
import com.app.bankbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        String email = request.email().trim().toLowerCase();

        if(userRepository.existsByEmailIgnoreCase(email)){
            throw new EmailAlreadyUsedException(email);
        }

        String hash = passwordEncoder.encode(request.password());

        User user = User.builder()
                .email(email)
                .passwordHash(hash)
                .role(User.Role.USER)
                .enabled(true)
                .locked(false)
                .build();

        userRepository.save(user);
    }
}
