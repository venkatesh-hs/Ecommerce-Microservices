package com.revival.inventory.user.repository;


import com.revival.inventory.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {

    User findByEmail(String email);
}
