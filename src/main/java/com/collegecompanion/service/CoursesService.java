package com.collegecompanion.service;

import com.collegecompanion.model.Courses;
import com.collegecompanion.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Courses> getCourses() {
        return coursesRepository.findAll();
    }

    public Courses addCourses(Courses courses) {
        return coursesRepository.save(courses);
    }

    public Courses updateCourse(Integer id, Courses updatedCourse) {
        return coursesRepository.findById(id)
                .map(course -> {
                    course.setTitle(updatedCourse.getTitle());
                    course.setDescription(updatedCourse.getDescription());
                    return coursesRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    public void deleteCourses(Integer id) {
        coursesRepository.deleteById(id);
    }
}
