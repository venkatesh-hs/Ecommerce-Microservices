package com.revival.inventory.cart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    BigInteger totalPrice;
    List<BookItem> bookItems;
}
