package com.app.bankbackend.auth.api.dto;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    // private final AuthService authService;
    //
    // public AuthController(AuthService authService) {
    //     this.authService = authService;
    // }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register (@Valid @RequestBody RegisterRequest registerRequest) {

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        // var response = authService.login(request);
        // return ResponseEntity.ok(response);

        // placeholder:


        //zamiast wysyłać refresh token w JSON, lepiej:
        //
        //refresh token jako HttpOnly Secure Cookie,
        //
        //w body tylko access token.
        return ResponseEntity.ok(new AuthResponse("access-token", "refresh-token", 600));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@Valid @RequestBody RefreshRequest request) {
        // var response = authService.refresh(request);
        // return ResponseEntity.ok(response);

        // placeholder:

        //zamiast wysyłać refresh token w JSON, lepiej:
        //
        //refresh token jako HttpOnly Secure Cookie,
        //
        //w body tylko access token.
        return ResponseEntity.ok(new AuthResponse("new-access-token", "new-refresh-token", 600));
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(@Valid @RequestBody LogoutRequest request) {
        // authService.logout(request);
    }
}