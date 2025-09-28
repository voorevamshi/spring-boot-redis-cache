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

    @Cacheable(value = "books", key = "#id" ,unless="#result == null")
    public Book getBookById(String id) {
        System.out.println("Fetching from DB for id: " + id);
        return repository.findById(id).orElse(null);
    }

    @CachePut(value = "books", key = "#book.id")
    public Book updateBook(Book book) {
    	 System.out.println("Saved book id: " + book.getId());
        return repository.save(book);
    }

    @CacheEvict(value = "books", key = "#id")
    public String deleteBook(String id) {
    	System.out.println("Deleted book id: " + id);
        repository.deleteById(id);
        return "Book deleted successfully";
    }
}