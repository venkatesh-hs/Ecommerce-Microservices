package com.revival.inventory.book.repository;

import com.revival.inventory.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BookRepository extends JpaRepository<Book, BigInteger> {

}
