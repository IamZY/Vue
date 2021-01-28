package com.ntuzy.springboottest.repository;

import com.ntuzy.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());

    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("Java");
        book.setAuthor("ntuzy");
        bookRepository.save(book);
    }

    @Test
    void findById() {
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(123);
        book.setName("测试测试");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete() {
        Book book = new Book();
        book.setId(123);
        bookRepository.delete(book);
    }

}