package com.book.controller;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Publisher;
import com.book.service.AuthorService;
import com.book.service.BookService;
import com.book.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
public class MainController {

    private BookService bookService;
    private AuthorService authorService;
    private PublisherService publisherService;

    @GetMapping({"/", "/books"})
    public ModelAndView main(ModelAndView view) {
        List<Book> bookList = bookService.findAll();

        view.addObject("bookList", bookList);
        view.setViewName("index");

        return view;
    }

    @GetMapping("/books/new")
    public ModelAndView newBook(ModelAndView view) {
        view.addObject("authors", authorService.findAll());
        view.addObject("publishers", publisherService.findAll());
        view.setViewName("book_insert");

        return view;
    }

    @PostMapping("/books/new")
    public String newBook(Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/books/search")
    @ResponseBody
    public List<Book> searchBook(String txt) {
        System.out.println(txt);
        List<Book> bookList = bookService.findByBookName(txt);
        System.out.println(bookList);
        return bookList;
    }

    @GetMapping("/books/{isbn}/delete")
    public String deleteBook(@PathVariable(name = "isbn") String isbn) {
        bookService.delete(isbn);
        return "redirect:/";
    }

    @GetMapping("/books/{isbn}/edit")
    public ModelAndView editBook(@PathVariable(name = "isbn") String isbn, ModelAndView view) {
        Book book = bookService.findByIsbn(isbn);
        //null check
        if (book == null) {
            return new ModelAndView("redirect:/");
        }
        view.addObject("book", book);
        view.addObject("authors", authorService.findAll());
        view.addObject("publishers", publisherService.findAll());
        view.setViewName("book_edit");
        return view;
    }

    @PostMapping("/books/{isbn}/edit")
    public String editBook(@PathVariable(name = "isbn") String isbn, Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/books/price")
    public ModelAndView price(ModelAndView view) {
        List<Book> bookList = bookService.findByAuthorCode();
        view.addObject("bookList", bookList);
        view.setViewName("book_price");
        return view;
    }

    @GetMapping("/books/top10")
    public ModelAndView top10(ModelAndView view) {
        List<Book> bookList = bookService.findTop10ByOrderByPriceDesc();
        view.addObject("bookList", bookList);
        view.setViewName("book_top10");
        return view;
    }

    @GetMapping("/books/list")
    public ModelAndView paggingList(ModelAndView view, @RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, org.springframework.data.domain.Sort.by("price").descending());
        Page<Book> pageList = bookService.findAll(pageRequest);
        List<Book> bookListPage = pageList.toList();
        //페이징 정보 저장
        System.out.println(pageList);
        System.out.println(pageList.getTotalPages());
        System.out.println(pageList.getTotalElements());
        System.out.println(pageList.getNumber());
        view.addObject("page", page);
        view.addObject("pageList", pageList);
        view.addObject("bookList", bookListPage);
        view.setViewName("book_pagging");
        return view;
    }

    //도서정보 저자 이름 일부로 검색 - 조인까지 추가
    @GetMapping("/books/author")
    public ModelAndView author(ModelAndView view, @RequestParam(name = "txt") String txt) {
        System.out.println(txt);
        List<Book> bookList = bookService.findByAuthorName(txt);
        view.addObject("bookList", bookList);
        view.setViewName("book_author");
        return view;
    }

    @GetMapping("/authors")
    public ModelAndView authors(ModelAndView view) {
        view.addObject("authors", authorService.findAll());
        view.setViewName("author_main");
        return view;
    }

    @GetMapping("/authors/search")
    @ResponseBody
    public List<Author> searchAuthor(@RequestParam(name = "txt") String txt) {
        System.out.println(txt);
        List<Author> authorList = authorService.findByAuthorNameContains(txt);
        System.out.println(authorList);
        return authorList;
    }

    @PostMapping("/authors/new")
    @ResponseBody
    public Map<String, Object> newAuthor(@RequestBody Author author) {
        try {
            authorService.save(author);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }

    }

    @PutMapping("/authors/update")
    @ResponseBody
    public Map<String, Object> editAuthor(@RequestBody Author author) {
        try {
            authorService.updateAuthor(author);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }
    }

    @DeleteMapping("/authors/delete/{authorCode}")
    @ResponseBody
    public Map<String, Object> deleteAuthor(@PathVariable(name = "authorCode") String authorCode) {
        try {
            authorService.deleteAuthor(authorCode);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }
    }

    @GetMapping("/publishers")
    public ModelAndView publishers(ModelAndView view) {
        view.addObject("authors", authorService.findAll());
        view.setViewName("publisher_main");
        return view;
    }

    @GetMapping("/publishers/search")
    @ResponseBody
    public List<Publisher> searchPublisher(@RequestParam(name = "txt") String txt) {
        List<Publisher> authorList = publisherService.findByPublisherNameContains(txt);
        return authorList;
    }

    @PostMapping("/publishers/new")
    @ResponseBody
    public Map<String, Object> newPublisher(@RequestBody Publisher publisher) {
        try {
            publisherService.save(publisher);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }
    }

    @PutMapping("/publishers/update")
    @ResponseBody
    public Map<String, Object> editPublisher(@RequestBody Publisher publisher) {
        try {
            publisherService.updatePublisher(publisher);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }
    }

    @DeleteMapping("/publishers/{publisherCode}")
    @ResponseBody
    public Map<String, Object> deletePublisher(@PathVariable(name = "publisherCode") String publisherCode) {
        try {
            publisherService.deletePublisher(publisherCode);
            return Map.of("result", "success");
        } catch (Exception e) {
            return Map.of("result", "error");
        }
    }
}
