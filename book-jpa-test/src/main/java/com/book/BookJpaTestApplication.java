package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"com.book.repository"})
@EntityScan(basePackages = {"com.book.entity"})
@SpringBootApplication
public class BookJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookJpaTestApplication.class, args);
	}

}
