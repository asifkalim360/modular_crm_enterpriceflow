package com.crm.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeansConfig {      // Spring configuration class hai.

    @Bean
    public PasswordEncoder passwordEncoder() {  // Spring container me PasswordEncoder bean create karo.

        return new BCryptPasswordEncoder();     // BCrypt algorithm use karo password hashing ke liye.
    }
}
// Ye bahut important security concept hai.
// Ye code humlog isliye banate hain taki Spring application me password ko securely encrypt/hash kar sake.
