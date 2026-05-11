package com.crm.modules.auth.controller;

import com.crm.modules.auth.dto.AuthResponse;
import com.crm.modules.auth.dto.LoginRequest;
import com.crm.modules.auth.dto.RegisterRequest;
import com.crm.modules.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Register Api
    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request)
    {
        return authService.register(request);
    }

    // Login API
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request)
    {
        return authService.login(request);
    }

}
