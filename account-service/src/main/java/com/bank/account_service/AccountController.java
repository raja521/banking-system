package com.bank.account_service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @GetMapping("/test1")
    public String test() {
        return "Account Service is up and running!";
    }

    @Value("${custom.message}")
    private String customMessage;

    @GetMapping("/message")
    public String getMessage() {
        return this.customMessage;
    }

    // Add an endpoint to call the Customer Service using Feign Client
    private final AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("/customer-status")
    public String getCustomerServiceStatus() {
        return accountService.getCustomerServiceStatus();
    }
}