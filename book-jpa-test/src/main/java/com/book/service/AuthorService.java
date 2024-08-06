package com.book.service;

import com.book.entity.Author;
import com.book.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByAuthorNameContains(String txt) {
        return authorRepository.findAllByAuthorNameContains(txt);
    }

    @Transactional()
    public void save(Author author) throws IllegalArgumentException {
        //중복 체크
        if (authorRepository.findByAuthorCode(author.getAuthorCode()).isPresent()) {
            throw new IllegalArgumentException("Author code already exists");
        }

        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(String authorCode) {
        authorRepository.deleteById(authorCode);
    }

}
