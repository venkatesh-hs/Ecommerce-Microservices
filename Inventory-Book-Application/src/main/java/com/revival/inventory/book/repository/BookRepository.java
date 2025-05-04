package com.revival.inventory.book.repository;

import com.revival.inventory.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, BigInteger> {

    @Query(value = Queries.GET_BOOKS, nativeQuery = true)
    List<Book> getBooks(String titles, String authors, String categories, Integer minPrice, Integer maxPrice);
}


interface Queries {
    String GET_BOOKS = """
            SELECT *
                FROM _book
                WHERE
                    (:titles = '' OR FIND_IN_SET(title, :titles) > 0)
                    AND (:authors = '' OR FIND_IN_SET(author, :authors) > 0)
                    AND (:categories = '' OR FIND_IN_SET(category, :categories) > 0)
                    AND (:minPrice IS NULL OR price >= :minPrice)
                    AND (:maxPrice IS NULL OR price <= :maxPrice);
            """;
}
