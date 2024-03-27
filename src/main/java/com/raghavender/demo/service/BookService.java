package com.raghavender.demo.service;

import java.util.List;

import com.raghavender.demo.entity.Book;

public interface BookService {

	Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Book book);
    void deleteBook(Long id);
}
