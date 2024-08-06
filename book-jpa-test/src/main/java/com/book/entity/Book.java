package com.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    @Column(length = 13)
    private String isbn;
    @Column(name = "book_name", length = 100)
    private String bookName;
    @Column(length = 10)
    private int price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_code")
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_code")
    private Publisher publisher;
}
