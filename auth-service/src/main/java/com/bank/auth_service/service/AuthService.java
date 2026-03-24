package com.bank.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.auth_service.entity.User;
import com.bank.auth_service.repository.UserRepository;
import com.bank.auth_service.security.JwtUtil;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register( User user) {
        // Registration logic here
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(String username, String password) {
        // Authentication logic here
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPassword().equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
