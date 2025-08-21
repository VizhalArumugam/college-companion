package com.collegecompanion.controller;

import com.collegecompanion.model.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @GetMapping
    public List<Courses> getCourses() {
        return Arrays.asList(
                new Courses(101, "Data Structures", "Dr. Shabariram C P"),
                new Courses(102, "Operating Systems", "Dr. Mahavishnu V C"),
                new Courses(103, "Database Management Systems", "Dr. Hemkiran S")
        );
    }
}
