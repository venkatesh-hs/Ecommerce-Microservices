package com.revival.inventory.auth.entities;

import com.revival.inventory.auth.entities.external.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticatedUser {
    User user;
    String token;
}
