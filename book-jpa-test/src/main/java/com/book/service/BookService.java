package com.book.service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findByBookName(String txt) {
        return bookRepository.findByBookNameContains(txt);
    }

    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    //만원에서 2만원까지 도서 검색
    public List<Book> findByAuthorCode() {
        return bookRepository.findByPriceBetween(10000, 20000);
    }

    public List<Book> findTop10ByOrderByPriceDesc() {
        return bookRepository.findTop10ByOrderByPriceDesc();
    }

    public List<Book> findAllOrderByPriceDesc() {
        return bookRepository.findAllByOrderByPriceDesc();
    }

    public Page<Book> findAll(PageRequest pageRequest) {
        return bookRepository.findAll(pageRequest);
    }

    public List<Book> findByAuthorName(String txt) {
        return bookRepository.findByAuthorName(txt);
    }
}
