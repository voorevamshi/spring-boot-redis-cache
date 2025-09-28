package com.vmc.redis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmc.redis.model.Book;
import com.vmc.redis.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public Book get(@PathVariable String id) {
    	System.out.println("id:"+id);
        return Optional.ofNullable(service.getBookById(id)).orElse(new Book());
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
    	System.out.println("book:"+book);
        return service.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
    	System.out.println("delete id:"+id);
        return service.deleteBook(id);
    }
}