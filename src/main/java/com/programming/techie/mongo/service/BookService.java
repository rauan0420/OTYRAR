package com.programming.techie.mongo.service;

import com.programming.techie.mongo.model.Book;
import com.programming.techie.mongo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.insert(book);
    }

    public void updateBook(Book book) {
        Book savedBook = bookRepository.findById(book.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Book by ID %s", book.getId())));
        savedBook.setBookName(book.getBookName());
        savedBook.setBookGenre(book.getBookGenre());
        savedBook.setBookAuthor(book.getBookAuthor());
        savedBook.setBookDetails(book.getBookDetails());
        savedBook.setBookDate(book.getBookDate());
        savedBook.setBookPage(book.getBookPage());
        savedBook.setLibrary(book.getLibrary());
        savedBook.setBookRating(book.getBookRating());

        bookRepository.save(book);
    }

    public Book getBook(String name) {
        return bookRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Book by Name - %s", name)));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBooks(String id) {
        bookRepository.deleteById(id);
    }
}
