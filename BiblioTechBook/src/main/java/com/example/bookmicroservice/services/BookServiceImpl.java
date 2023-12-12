package com.example.bookmicroservice.services;

import com.example.bookmicroservice.entities.Book;
import com.example.bookmicroservice.entities.TypeGenre;
import com.example.bookmicroservice.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBook {
    private BookRepository bookRepository;
    public Book addBook(Book b) {
        return bookRepository.save(b);
    }

    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }

    public void deleteBook(Long idB) {
        bookRepository.deleteById(idB);
    }

    public Book findById(Long idB) {
        return bookRepository.findById(idB).orElse(null);
    }

    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByGenre(TypeGenre typeGenre) {
        return bookRepository.findByGenre(typeGenre);
    }

    @Override
    public List<Book> findBooksByAuther(String auther) {
        return bookRepository.findByAuthor(auther);
    }

    @Override
    public List<Book> findAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }
}
