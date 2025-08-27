package com.collegecompanion.controller;

import com.collegecompanion.model.Courses;
import com.collegecompanion.service.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Courses> getCourses() {
        return coursesService.getCourses();
    }

    @PostMapping
    public Courses addCourses(@RequestBody Courses courses) {
        return coursesService.addCourses(courses);
    }

    @PutMapping("/{id}")
    public Courses updateCourses(@PathVariable Integer id, @RequestBody Courses courses) {
        return coursesService.updateCourse(id, courses);
    }

    @DeleteMapping("/{id}")
    public String deleteCourses(@PathVariable Integer id) {
        coursesService.deleteCourses(id);
        return "Course deleted with id "+id;
    }
}
