package com.collegecompanion.service;

import com.collegecompanion.model.Student;
import com.collegecompanion.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student update) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(update.getName());
                    student.setEmail(update.getEmail());
                    student.setPassword(update.getPassword());
                    return studentRepository.save(student);
                })
                .orElseThrow(() ->new RuntimeException("Courses not found with id "+id));
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
}
