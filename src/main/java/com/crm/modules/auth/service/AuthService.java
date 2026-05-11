package com.crm.modules.auth.service;

import com.crm.modules.auth.dto.AuthResponse;
import com.crm.modules.auth.dto.LoginRequest;
import com.crm.modules.auth.dto.RegisterRequest;

public interface AuthService {

    public AuthResponse register(RegisterRequest request);

    public AuthResponse login(LoginRequest request);

}
