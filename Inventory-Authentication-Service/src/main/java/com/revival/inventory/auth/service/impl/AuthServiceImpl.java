package com.revival.inventory.auth.service.impl;

import com.revival.inventory.auth.entities.AuthenticatedUser;
import com.revival.inventory.auth.entities.external.User;
import com.revival.inventory.auth.service.AuthService;
import com.revival.inventory.auth.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;

    @Override
    public AuthenticatedUser authenticateUser(User user) throws Exception {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );
            if (authenticate.isAuthenticated()) {
                return AuthenticatedUser.builder()
                        .user(userServiceClient.getUserByEmail(user.getEmail()))
                        .token(jwtService.generateToken(user))
                        .build();
            } else {
                throw new RuntimeException("Not a valid user");
            }
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new Exception(exception.getMessage());
        }
    }
}
