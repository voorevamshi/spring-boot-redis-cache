package com.vmc.redis.service;

import com.vmc.redis.model.Book;
import com.vmc.redis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Cacheable(value = "books", key = "#id")
    public Book getBookById(String id) {
        System.out.println("Fetching from DB for id: " + id);
        return repository.findById(id).orElse(null);
    }

    @CachePut(value = "books", key = "#book.id")
    public Book updateBook(Book book) {
        return repository.save(book);
    }

    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(String id) {
        repository.deleteById(id);
    }
}