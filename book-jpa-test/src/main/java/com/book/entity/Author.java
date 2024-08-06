package com.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "author_code",length = 6)
    private String authorCode;

    @Column(name = "author_name",length = 100)
    private String authorName;

}
