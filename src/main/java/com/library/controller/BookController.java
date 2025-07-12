package com.library.controller;

import com.library.entity.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book b){
        return service.saveBook(b);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book b){
        return service.updateBook(b);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @DeleteMapping("/delete")
    public boolean deleteBook(@RequestParam int id){
        return service.deleteBook(id);
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable int id){
        return service.getBookById(id);
    }

    @PatchMapping("/changeAvailability/{id}")
    public ResponseEntity<String> changeAvailability(@PathVariable int id,@RequestBody Map<String, Boolean> request){
        boolean isAvailable = request.get("isAvailable");
        boolean updated = service.changeAvailability(id, isAvailable);
        if (updated) {
            return ResponseEntity.ok("Availability updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
    }

}
