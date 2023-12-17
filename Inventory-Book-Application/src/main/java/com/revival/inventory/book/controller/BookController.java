package com.revival.inventory.book.controller;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

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
    private ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity
                .ok()
                .body(bookService.getBooks());
    }
}
