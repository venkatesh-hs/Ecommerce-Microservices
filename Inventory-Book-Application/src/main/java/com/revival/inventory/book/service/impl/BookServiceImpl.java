package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.repository.BookRepository;
import com.revival.inventory.book.service.BookService;
import com.revival.inventory.book.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Utils utils;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks(List<String> titles, List<String> authors, List<String> categories, Integer minPrice, Integer maxPrice) {
        return bookRepository.getBooks(
                utils.getCommaSeparatedString(titles),
                utils.getCommaSeparatedString(authors),
                utils.getCommaSeparatedString(categories),
                minPrice,
                maxPrice
        );
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
