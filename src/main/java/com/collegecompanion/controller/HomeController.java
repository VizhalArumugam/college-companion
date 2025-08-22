package com.collegecompanion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to College Companion API! Available endpoints: /students, /courses, /notices, /events";
    }
}
