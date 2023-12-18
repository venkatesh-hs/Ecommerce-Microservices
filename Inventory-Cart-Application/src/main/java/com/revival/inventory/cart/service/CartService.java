package com.revival.inventory.cart.service;

import com.revival.inventory.cart.entities.Cart;
import com.revival.inventory.cart.entities.CartItem;

import java.math.BigInteger;

public interface CartService {
    Cart addToCart(CartItem cartItem);

    Cart getUserCart(BigInteger userId);

    Cart removeFromCart(BigInteger userId, BigInteger bookId);
}
