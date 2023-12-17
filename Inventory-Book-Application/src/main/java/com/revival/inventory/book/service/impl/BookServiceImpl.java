package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.repository.BookRepository;
import com.revival.inventory.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(BigInteger bookId) {
        Optional<Book> books = bookRepository.findById(bookId);
        return books.orElse(null);
    }

    @Override
    public List<Book> bulkUpload(List<Book> books) {
        return books.stream()
                .map(this::createBook)
                .toList();
    }
}
