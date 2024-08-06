package com.book.service;

import com.book.entity.Publisher;
import com.book.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public List<Publisher> findByPublisherNameContains(String txt) {
        return publisherRepository.findAllByPublisherNameContains(txt);
    }

    public void save(Publisher publisher) {
        if (publisherRepository.findById(publisher.getPublisherCode()).isPresent()) {
            throw new IllegalArgumentException("Publisher code already exists");
        }
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(String publisherCode) {
        publisherRepository.deleteById(publisherCode);
    }
}
