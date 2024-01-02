package com.revival.inventory.auth.controller;

import com.revival.inventory.auth.entities.AuthenticatedUser;
import com.revival.inventory.auth.entities.external.User;
import com.revival.inventory.auth.service.AuthService;
import com.revival.inventory.auth.service.impl.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/authenticate")
    private ResponseEntity<AuthenticatedUser> authenticateUser(@RequestBody User user) throws Exception {
        return ResponseEntity
                .ok(authService.authenticateUser(user));
    }

    @GetMapping("/extractEmail")
    private ResponseEntity<String> extractUserEmail(@PathVariable String jwt) {
        return ResponseEntity
                .ok(jwtService.extractUserEmail(jwt));
    }

    @GetMapping("/isTokenValid")
    private ResponseEntity<Boolean> isTokenValid(String jwt, @RequestBody UserDetails user) {
        return ResponseEntity
                .ok(jwtService.isTokenValid(jwt, user));
    }
}
