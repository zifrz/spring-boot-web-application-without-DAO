package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/book")
public class BookController {
    static ArrayList<Book> books = new ArrayList<>();
    int bookCounter = 0;

    @PostMapping
    @ResponseBody
    public Boolean addBook(@RequestBody Book book) {
        book.setId(++bookCounter);
        books.add(book);
        return true;
    }

    @GetMapping
    @ResponseBody
    public ArrayList<Book> getBooks() {
        return books;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Boolean updateBook(@RequestBody Book book, @PathVariable int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, book);
            }
        }
        return true;
    }


    @GetMapping("/{id}")
    public Book getLibrarians(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
