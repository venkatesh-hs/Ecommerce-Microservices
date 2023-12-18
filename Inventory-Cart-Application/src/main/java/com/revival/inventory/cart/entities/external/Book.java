package com.revival.inventory.cart.entities.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private BigInteger id;
    private String title;
    private BigInteger price;
    private String imagePath;
}
