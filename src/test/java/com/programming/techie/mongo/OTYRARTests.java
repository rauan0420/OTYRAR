package com.programming.techie.mongo;

import com.programming.techie.mongo.model.Book;
import com.programming.techie.mongo.model.BookGenre;
import com.programming.techie.mongo.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class OTYRARTests {

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Test Whether Expenses are pre-populated")
    void shouldReturnPrePopulatedExpenses() {
        List<Book> expens = bookRepository.findAll();
        assertEquals(5, expens.size());
    }

    @Test
    @DisplayName("Should Find Book By Name")
    void shouldFindExpenseByName() {
        Book expectedBook = new Book();
        expectedBook.setBookName("Evening Drinks");
        expectedBook.setBookGenre(BookGenre.ROMANCE);
        bookRepository.save(expectedBook);

        Book actualBook = bookRepository.findByName("Evening Drinks").orElseThrow();
        assertEquals(expectedBook.getBookName(), actualBook.getBookName());
        assertEquals(expectedBook.getBookGenre(), actualBook.getBookGenre());

    }
}

