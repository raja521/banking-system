package com.bank.account_service;

import org.springframework.stereotype.Service;

import com.bank.account_service.client.CustomerClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@Service
public class AccountService {
    
    private final CustomerClient customerClient;

    public AccountService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @Retry(name = "customerService", fallbackMethod = "customerServiceFallback")
    @RateLimiter(name = "customerService", fallbackMethod = "customerServiceFallback")
    @CircuitBreaker(name = "customerService", fallbackMethod = "customerServiceFallback")
    public String getCustomerServiceStatus() {

        // Call the Customer Service using Feign Client
        return customerClient.test();
    }

    // Fallback method for Circuit Breaker
    public String customerServiceFallback(Throwable t) {
        return "Customer Service is currently unavailable. Please try again later.";
    }
}
