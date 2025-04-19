package com.revival.inventory.cart.controller;


import com.revival.inventory.cart.entities.Cart;
import com.revival.inventory.cart.entities.CartItem;
import com.revival.inventory.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    private ResponseEntity<Cart> addToCart(@RequestBody CartItem cartItem) {
        return ResponseEntity
                .ok()
                .body(cartService.addToCart(cartItem));
    }

    @GetMapping(path = "/{user_id}")
    private ResponseEntity<Cart> GetUserCart(@PathVariable("user_id") BigInteger userId) {
        return ResponseEntity
                .ok()
                .body(cartService.getUserCart(userId));
    }

    @PatchMapping(path = "/{user_id}/remove/{book_id}")
    private ResponseEntity<Cart> removeFromCart(@PathVariable("user_id") BigInteger userId, @PathVariable("book_id") BigInteger bookId) {
        return ResponseEntity
                .ok()
                .body(cartService.removeFromCart(userId, bookId));
    }
}
