package com.book.repository;

import com.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {
    List<Author> findAllByAuthorNameContains(String txt);

    Optional<Object> findByAuthorCode(String authorCode);

    void deleteById(String authorCode);
}
