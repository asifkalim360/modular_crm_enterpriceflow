package com.crm.modules.auth.service.impl;

import com.crm.modules.auth.dto.*;
import com.crm.modules.auth.service.AuthService;
import com.crm.modules.user.entity.User;
import com.crm.modules.user.repository.UserRepository;
import com.crm.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    // DEPENDENCY INJECTION
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    //  REGISTER USER
    @Override
    public AuthResponse register(RegisterRequest request) {
        // Check email already exists
        if(userRepository.existsByEmail(request.getEmail()))
        {
            throw new RuntimeException("Email already exists");
        }

        // Create user object
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                // ENCODE PASSWORD
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        // Save user
        userRepository.save(user);

        // generate token
        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("User registered successfully")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Match password
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
        {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("Login succeessful")
                .build();
    }
}
