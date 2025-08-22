package com.collegecompanion.service;

import com.collegecompanion.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return Arrays.asList(
                new Student(1, "Rahul", "rahul@example.com","rahul1"),
                new Student(2, "Anitha", "anitha@example.com","anitha2"),
                new Student(3, "Kiran", "kiran@example.com","kiran3")
        );
    }
}
