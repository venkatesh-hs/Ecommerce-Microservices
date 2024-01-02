package com.revival.inventory.auth.service;

import com.revival.inventory.auth.entities.AuthenticatedUser;
import com.revival.inventory.auth.entities.external.User;

public interface AuthService {
    AuthenticatedUser authenticateUser(User user) throws Exception;
}
