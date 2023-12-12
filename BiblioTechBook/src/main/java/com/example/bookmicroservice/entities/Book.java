package com.example.bookmicroservice.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;

    private String title;

    private String author;

    @Enumerated(EnumType.STRING)
    private TypeGenre genre;

    private Boolean available;
    private String imageUrl;

    public Book(String title, String author, TypeGenre genre, Boolean available, String imageUrl) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.imageUrl = imageUrl;
    }
}
