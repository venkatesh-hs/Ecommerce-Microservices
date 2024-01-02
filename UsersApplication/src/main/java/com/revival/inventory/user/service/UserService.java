package com.revival.inventory.user.service;

import com.revival.inventory.user.entities.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    Optional<User> getUser(BigInteger userId);

    User getUser(String email);
}
