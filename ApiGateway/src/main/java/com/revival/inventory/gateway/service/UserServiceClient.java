package com.revival.inventory.gateway.service;

import com.revival.inventory.gateway.service.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-ws")
public interface UserServiceClient {

    @GetMapping("/api/v1/users/{email}")
    User getUserByEmail(@PathVariable String email);
}
