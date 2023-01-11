package com.programming.techie.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("book")
public class Book {
    @Id
    private String id;
    @Field("name")
    @Indexed(unique = true)
    private String bookName;
    @Field("genre")
    private BookGenre bookGenre;
    @Field("rating")
    private Integer bookRating;
    @Field("date")
    private  String bookDate;
    @Field("page")
    private Integer bookPage;
    @Field("author")
    private String bookAuthor;
    @Field("library")
    private String Library;
    @Field("details")
    private String bookDetails;
}
