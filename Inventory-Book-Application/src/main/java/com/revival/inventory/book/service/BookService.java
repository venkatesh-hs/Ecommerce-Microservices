package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> getBooks(List<String> titles, List<String> authors, List<String> categories, Integer minPrice, Integer maxPrice);

    Book getBook(BigInteger bookId);

    List<Book> bulkUpload(List<Book> books);
}
