package com.example.bookmicroservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;

    private String title;

    private String auther;

    @Enumerated(EnumType.STRING)
    private TypeGenre genre;

    private Boolean available;

}
