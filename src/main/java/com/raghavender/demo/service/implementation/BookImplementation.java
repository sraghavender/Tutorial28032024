package com.raghavender.demo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavender.demo.entity.Book;
import com.raghavender.demo.repository.BookRepository;
import com.raghavender.demo.service.BookService;
@Service
public class BookImplementation implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Override
	public Book createBook(Book book) {
	return bookRepository.save(book);
	
	}
	@Override
    public Book getBookById(Long id) {
    return	bookRepository.findById(id).get();
    }
    
    public List<Book> getAllBooks(){
    	return bookRepository.findAll();
    }
   public Book updateBook(Book book) {
    Book existingBook;
    existingBook=bookRepository.findById(book.getId()).get();
    existingBook.setAuthor(book.getAuthor());
    existingBook.setDescription(book.getDescription());
    existingBook.setGenre(book.getGenre());
    existingBook.setTitle(book.getTitle());
    return bookRepository.save(existingBook);
   }
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
