package com.revival.inventory.cart.entities;

import com.revival.inventory.cart.entities.external.Book;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class BookItem extends Book {

    private BigInteger quantity;

    @Builder
    public BookItem(BigInteger id, String title, BigInteger price, String imagePath, BigInteger quantity) {
        super(id, title, price, imagePath);
        this.quantity = quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }
}
