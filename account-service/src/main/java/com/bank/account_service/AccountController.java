package com.bank.account_service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @GetMapping("/test")
    public String test() {
        return "Account Service is up and running!";
    }

    @Value("${custom.message}")
    private String customMessage;

    @GetMapping("/message")
    public String getMessage() {
        return this.customMessage;
    }
    
}