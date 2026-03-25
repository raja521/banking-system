package com.bank.transaction_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @GetMapping("/test")
    public String getTransaction() {
        return "Transaction service is working!";
    }
    
}
