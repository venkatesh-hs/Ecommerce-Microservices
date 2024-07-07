package com.revival.inventory.auth.service;


import com.revival.inventory.auth.entities.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-ws")
public interface UserServiceClient {

    @GetMapping("/api/v1/users/email/{email}")
    User getUserByEmail(@PathVariable String email);
}
