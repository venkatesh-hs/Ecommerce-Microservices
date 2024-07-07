package com.revival.inventory.gateway.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private BigInteger id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
