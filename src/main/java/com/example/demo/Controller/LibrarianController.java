package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.BookIssue;
import com.example.demo.Model.Librarian;
import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    static ArrayList<Librarian> librarians = new ArrayList<>();
    static ArrayList<BookIssue> bookIssues = new ArrayList<>();

    @ResponseBody
    @PostMapping
    public Librarian addLibrarian(@RequestBody Librarian librarian) {
        librarians.add(librarian);
        return librarian;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Librarian getLibrarians(@PathVariable int id) {
        for (Librarian librarian : librarians) {
            if (librarian.getId() == id) {
                return librarian;
            }
        }
        return null;
    }

    
    @PostMapping("/issue")
    public boolean issueBook(@RequestParam int studentId, @RequestParam int bookId) {
        // Check if the student exists
        Student student = getStudentById(studentId);
        Book book = getBookById(bookId);
        if (student == null || book == null) {
            return false;
        }

        // Create a new BookIssue object and add to bookIssues list
        BookIssue bookIssue = new BookIssue(student, book);
        bookIssues.add(bookIssue);
        return true;
    }

    private Student getStudentById(int studentId) {
        for (Student student : StudentController.students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Helper method to get book by ID from BookController
    private Book getBookById(int bookId) {
        for (Book book : BookController.books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
