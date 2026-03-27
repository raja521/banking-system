package com.bank.account_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "customer-service")
public interface CustomerClient {
    
    @GetMapping("/customers/test")
    String test();
}
