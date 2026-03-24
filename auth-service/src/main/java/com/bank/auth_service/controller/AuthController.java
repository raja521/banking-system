package com.bank.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.auth_service.entity.User;
import com.bank.auth_service.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")   
    public String register(@RequestBody User user) {
        // Registration endpoint logic here
        return authService.register(user); // Replace null with actual user data
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Login endpoint logic here
        return authService.login(user.getUsername(), user.getPassword()); // Replace null with actual username and password
    }
    
}
