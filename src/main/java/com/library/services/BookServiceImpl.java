package com.library.services;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repo;

    @Override
    public String saveBook(Book b) {
        repo.save(b);
        return "Book Saved !";
    }

    @Override
    public ResponseEntity<Book> updateBook(Book b) {
        Optional<Book> book =repo.findById(b.getId());
        if(book.isPresent()){
            Book updatedBook=book.get();
            if (b.getTitle()!=null)
                updatedBook.setAuthor(b.getAuthor());
            if  (b.getTitle()!=null)
                updatedBook.setTitle(b.getTitle());
            if (b.getIsbn()!=null)
                updatedBook.setIsbn(b.getIsbn());
            if (b.getIsAvailable() != null)
                updatedBook.setIsAvailable(b.getIsAvailable());
            return ResponseEntity.ok(repo.save(updatedBook));
        }
        return ResponseEntity.notFound().build();
    }


    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Book getBook=repo.findById(id).orElse(null);
        return getBook;
    }

    @Override
    public boolean deleteBook(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeAvailability(int id,boolean isAvailable) {
        Optional<Book> optionalBook = repo.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setIsAvailable(isAvailable);
            repo.save(book);
            return true;
        }
        return false;
    }
}
