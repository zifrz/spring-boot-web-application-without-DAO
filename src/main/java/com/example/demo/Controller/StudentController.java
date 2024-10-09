package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("/student")
public class StudentController {
    static ArrayList<Student> students = new ArrayList<>();
    @PostMapping
    @ResponseBody

    public Boolean addStudent(@RequestBody Student student) {
        students.add(student);
        return true;
    }

    @GetMapping
    @ResponseBody
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Boolean updateBook(@RequestBody Student student, @PathVariable int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
            }
        }
        return true;
    }

    @GetMapping("/{id}")
    public Student getLibrarians(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
