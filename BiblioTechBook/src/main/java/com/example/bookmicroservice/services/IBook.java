package com.example.bookmicroservice.services;

import com.example.bookmicroservice.entities.Book;
import com.example.bookmicroservice.entities.TypeGenre;

import java.util.List;

public interface IBook {
    public Book addBook(Book b);

    public Book updateBook(Book b);

    public void deleteBook(Long idB);

    public Book findById(Long idB);

    public List<Book> findAllBook();

    List<Book> findBooksByGenre(TypeGenre typeGenre);
    List<Book> findBooksByAuther(String auther);
    List<Book> findAvailableBooks();
}
