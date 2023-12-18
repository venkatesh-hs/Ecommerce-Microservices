package com.revival.inventory.cart.service;

import com.revival.inventory.cart.entities.external.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

@FeignClient(name = "books-ws")
public interface BookServiceClient {
    @GetMapping("/api/v1/books/{id}")
    Book getBook(@PathVariable BigInteger id);
}
