package com.example.bookmicroservice.controllers;

import com.example.bookmicroservice.entities.Book;
import com.example.bookmicroservice.entities.TypeGenre;
import com.example.bookmicroservice.services.IBook;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private IBook iBook;

    @GetMapping("/add")
    public Book addBook(@RequestParam(name = "title") String title, @RequestParam(name = "author") String author, @RequestParam(name = "genre") TypeGenre genre, @RequestParam(name = "available") boolean available, @RequestParam(name = "imageUrl") String imageUrl){
        String new_img = "";
        try {
            new_img = URLDecoder.decode(imageUrl, StandardCharsets.UTF_8.toString());

        } catch (Exception ex) {

        }
        Book b = new Book(title, author, genre, available, new_img);
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
