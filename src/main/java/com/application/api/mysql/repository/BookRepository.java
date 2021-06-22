package com.application.api.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.api.mysql.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
