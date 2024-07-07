package com.revival.inventory.auth.controller;

import com.revival.inventory.auth.entities.AuthenticatedUser;
import com.revival.inventory.auth.entities.external.User;
import com.revival.inventory.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/authenticate")
    private ResponseEntity<AuthenticatedUser> authenticateUser(@RequestBody User user) throws Exception {
        return ResponseEntity
                .ok(authService.authenticateUser(user));
    }

}
