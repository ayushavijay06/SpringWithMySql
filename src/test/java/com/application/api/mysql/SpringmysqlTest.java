package com.application.api.mysql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.api.mysql.model.Book;
import com.application.api.mysql.repository.BookRepository;

@SpringBootTest
class SpringmysqlTest {

	@Autowired
	BookRepository bRepo;

	@Test
	public void testCreate() {
		Book b = new Book();
		b.setBookName("maths");
		b.setBookAuthor("sc chand");
		bRepo.save(b);
		assertNotNull(bRepo.findAll().get(1));

	}
}
