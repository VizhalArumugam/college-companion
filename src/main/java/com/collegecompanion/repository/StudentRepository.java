package com.collegecompanion.repository;

import com.collegecompanion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}

