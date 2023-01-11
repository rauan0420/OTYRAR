package com.programming.techie.mongo.controller;

import com.programming.techie.mongo.model.Book;
import com.programming.techie.mongo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{name}")
    public ResponseEntity getBookByName(@PathVariable String name) {
        return ResponseEntity.ok(bookService.getBook(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooks(@PathVariable String id) {
        bookService.deleteBooks(id);
        return ResponseEntity.noContent().build();
    }

}
