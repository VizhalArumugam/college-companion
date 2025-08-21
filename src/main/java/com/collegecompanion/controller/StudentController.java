package com.collegecompanion.controller;

import com.collegecompanion.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "Rahul", "rahul@example.com","rahul1"),
                new Student(2, "Anitha", "anitha@example.com","anitha2"),
                new Student(3, "Kiran", "kiran@example.com","kiran3")
        );
    }
}
