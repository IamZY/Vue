package com.ntuzy.springboottest.controller;

import com.ntuzy.springboottest.entity.Book;
import com.ntuzy.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/list")
    private List<Book> findAll() {
        return bookRepository.findAll();
    }
}
