package com.raghavender.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavender.demo.entity.Book;
import com.raghavender.demo.service.BookService;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@RestController

@Slf4j
@RequestMapping("api/books")

public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		
		
		Book saveBook = bookService.createBook(book);
		return new ResponseEntity<>(saveBook,HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookid) {
		Book book = bookService.getBookById(bookid);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books =bookService.getAllBooks();
		return new ResponseEntity<>(books,HttpStatus.OK);
		
	}
	@PutMapping("{id}")
	
	public ResponseEntity<Book> UpdateBook(@PathVariable("id") Long id, @RequestBody Book book){
		book.setId(id);
		Book updatedBook= bookService.updateBook(book);
		
		return new ResponseEntity<>(updatedBook,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
		log.debug("testing...");
		bookService.deleteBook(id);
		return new ResponseEntity<>("Book was deleted successfully",HttpStatus.OK);
		
	}
}
