package com.book.repository;

import com.book.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
    List<Publisher> findAllByPublisherNameContains(String txt);
}
