package com.collegecompanion.service;

import com.collegecompanion.model.Courses;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CoursesService {
    public List<Courses> getCourses() {
        return Arrays.asList(
                new Courses(101, "Data Structures", "Dr. Shabariram C P"),
                new Courses(102, "Operating Systems", "Dr. Mahavishnu V C"),
                new Courses(103, "Database Management Systems", "Dr. Hemkiran S")
        );
    }
}
