package com.bank.account_service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @GetMapping("/test")
    public String test() {
        return "Account Service is up and running!";
    }
    
}