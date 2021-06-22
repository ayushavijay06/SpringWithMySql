package com.application.api.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.mysql.model.Book;
import com.application.api.mysql.repository.BookRepository;

@RestController
@Validated
@ConfigurationProperties
public class BookController {

	@Value("${spring.datasource.url}")
	private String url;

	@Autowired
	BookRepository bookRepository;

	@PostMapping(path = "/book", produces = "application/json")
	public Book insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return book;

	}

	@PostMapping("/multiplebook")
	public List<Book> insertBook(@RequestBody List<Book> book) {
		bookRepository.saveAll(book);
		return book;
	}

	@GetMapping("/getallbook")
	public List<Book> getBook() {

		System.out.println("url:" + url);

		return (List<Book>) bookRepository.findAll();

	}

	@GetMapping("/getbookbyId/{bookId}")
	public Optional<Book> getBook(@PathVariable("bookId") Long id) {
		return bookRepository.findById(id);

	}

	@DeleteMapping("/deletebookbyId/{bookId}")
	public Optional<Book> getBook2(@PathVariable("bookId") Long id) {
		return bookRepository.findById(id);

	}
}
