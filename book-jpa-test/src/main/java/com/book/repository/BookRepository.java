package com.book.repository;

import com.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByBookNameContains(String txt);

    List<Book> findByPriceBetween(int i, int i1);

    List<Book> findTop10ByOrderByPriceDesc();

    List<Book> findAllByOrderByPriceDesc();

    @Query("SELECT b FROM Book b JOIN b.author a WHERE a.authorName LIKE CONCAT('%', :n, '%')")
    List<Book> findByAuthorName(@Param("n") String authorName);
}
