package com.revival.inventory.book.controller;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    private ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity
                .ok()
                .body(bookService.createBook(book));
    }

    @PostMapping("/bulkUpload")
    private ResponseEntity<List<Book>> bulkUpload(@RequestBody List<Book> books) {
        return ResponseEntity
                .ok()
                .body(bookService.bulkUpload(books));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> getBook(@PathVariable("id") BigInteger bookId) {
        return ResponseEntity
                .ok()
                .body(bookService.getBook(bookId));
    }

    @GetMapping
    private ResponseEntity<List<Book>> getBooks(@RequestParam(value = "name", required = false) List<String> titles,
                                                @RequestParam(value = "author", required = false) List<String> authors,
                                                @RequestParam(value = "category", required = false) List<String> categories,
                                                @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                                @RequestParam(value = "maxPrice", required = false) Integer maxPrice) {
        return ResponseEntity
                .ok()
                .body(bookService.getBooks(titles, authors, categories, minPrice, maxPrice));
    }
}
