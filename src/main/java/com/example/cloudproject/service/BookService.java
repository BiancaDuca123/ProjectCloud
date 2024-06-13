package com.example.cloudproject.service;

import com.example.cloudproject.entity.Book;
import com.example.cloudproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
