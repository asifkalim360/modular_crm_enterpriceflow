package com.crm.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // secret key
    private final String SECRET_KEY = "bXktc3VwZXItc2VjcmV0LWtleS1mb3Itand0LWF1dGgtdXNlLWNhc2U";
    // Token validity
    private final long EXPIRATION = 1000 * 60 * 60 * 24;

    // Generate signing key
    private Key getSignkey()
    {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate JWT token
    public String generateToken(String email)
    {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                .signWith(getSignkey(), SignatureAlgorithm.ES256)
                .signWith(getSignkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract email from token
    public String extractEmail(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSignkey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validation token
    public boolean validateToken(String token)
    {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignkey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

// Login → Generate JWT → Send Token → Client stores token →
// Every API request sends token → Backend validates token
