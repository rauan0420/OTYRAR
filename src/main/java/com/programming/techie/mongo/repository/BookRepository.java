package com.programming.techie.mongo.repository;

import com.programming.techie.mongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{'name': ?0}")
    Optional<Book> findByName(String name);
}
