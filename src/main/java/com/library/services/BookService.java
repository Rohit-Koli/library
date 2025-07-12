package com.library.services;

import com.library.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    String saveBook(Book b);
    ResponseEntity<Book> updateBook(Book b);
    List<Book> getAllBooks();
    Book getBookById(int id);
    boolean deleteBook(int id);
//    boolean isBookAvailable(int id);
    boolean changeAvailability(int id,boolean isAvailable);
}
