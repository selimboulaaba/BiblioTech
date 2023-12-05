package com.example.bookmicroservice.repositories;

import com.example.bookmicroservice.entities.Book;
import com.example.bookmicroservice.entities.TypeGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(TypeGenre typeGenre);
    List<Book> findByAuther(String auther);
    List<Book> findByAvailable(Boolean available);
}
