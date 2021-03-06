package com.ntuzy.springboottest.controller;

import com.ntuzy.springboottest.entity.Book;
import com.ntuzy.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/list/{page}/{size}")
    private Page<Book> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (null != result) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (null != result) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

}
