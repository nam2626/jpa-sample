package com.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Publisher {
    @Id
    @Column(name = "publisher_code", length = 6)
    private String publisherCode;
    @Column(name = "publisher_name", length = 100)
    private String publisherName;
}
