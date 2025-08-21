package com.collegecompanion.model;

import java.util.Objects;

public class Courses {
    private int id;
    private String title;
    private String instructor;

    public Courses() {}

    public Courses(int id, String title, String instructor) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return id == courses.id && Objects.equals(title, courses.title) && Objects.equals(instructor, courses.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, instructor);
    }
}
