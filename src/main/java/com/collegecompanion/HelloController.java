package com.collegecompanion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // tells Spring this is a REST API controller
public class HelloController {

    @GetMapping("/hello")  // maps to http://localhost:8080/hello
    public String hello() {
        return "Hello from College Companion Platform!";
    }
}
