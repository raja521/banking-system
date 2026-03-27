package com.bank.account_service;

import org.springframework.stereotype.Service;

import com.bank.account_service.client.CustomerClient;

@Service
public class AccountService {
    
    private final CustomerClient customerClient;

    public AccountService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public String getCustomerServiceStatus() {
        return customerClient.test();
    }
}
