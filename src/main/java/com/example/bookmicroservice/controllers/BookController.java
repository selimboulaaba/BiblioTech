package com.example.bookmicroservice.controllers;

import com.example.bookmicroservice.entities.Book;
import com.example.bookmicroservice.entities.TypeGenre;
import com.example.bookmicroservice.services.IBook;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private IBook iBook;

    @PostMapping("/add")
    public Book addBook( @RequestBody Book b){
        return iBook.addBook(b);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book b){
        return iBook.updateBook(b);
    }

    @DeleteMapping("/delete/{idB}")
    public void deleteBook(@PathVariable Long idB){
        iBook.deleteBook(idB);
    }

    @GetMapping("/getOne/{idB}")
    public Book findById(@PathVariable Long idB){
        return iBook.findById(idB);
    }

    @GetMapping("/getAll")
    public List<Book> findAllBook(){
        return iBook.findAllBook();
    }

    @GetMapping("/getByGenre/{type}")
    public List<Book> findBooksByGenre(@PathVariable TypeGenre type) {
        return iBook.findBooksByGenre(type);
    }

    @GetMapping("/getByAuther/{auther}")
    public List<Book> findBooksByAuther(@PathVariable String auther) {
        return iBook.findBooksByAuther(auther);
    }

    @GetMapping("/getAvailableBooks")
    public List<Book> findAvailableBooks() {
        return iBook.findAvailableBooks();
    }
}
