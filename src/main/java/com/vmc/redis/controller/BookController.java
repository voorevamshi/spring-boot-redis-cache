package com.vmc.redis.controller;

import com.vmc.redis.model.Book;
import com.vmc.redis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public Book get(@PathVariable String id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteBook(id);
    }
}