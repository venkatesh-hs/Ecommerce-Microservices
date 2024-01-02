package com.revival.inventory.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-ws")
public interface JwtAuthServiceClient {
    @GetMapping("/api/v1/auth/extractEmail")
    String extractUserEmail(@PathVariable String jwt);

    @GetMapping("/api/v1/auth/isTokenValid")
    boolean isTokenValid(@RequestParam(name = "jwt") String jwt, @RequestBody UserDetails userDetails);
}
