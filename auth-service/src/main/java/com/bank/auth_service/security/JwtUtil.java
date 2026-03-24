package com.bank.auth_service.security;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("thisIsASecretKeyThatIsAtLeast32BytesLongForHS256Algorithm".getBytes()); // In production, use a secure key and store it safely
    public String generateToken(String username) {
        // For simplicity, we are just returning the username as the token.
        // In a real application, you would use a library like jjwt to create a JWT token with claims and expiration.

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        // For simplicity, we are just returning the token as the username.
        // In a real application, you would parse the JWT token and validate it using the secret key.
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
