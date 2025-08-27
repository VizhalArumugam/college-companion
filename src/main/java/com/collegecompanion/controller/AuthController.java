package com.collegecompanion.controller;

import com.collegecompanion.model.AppUser;
import com.collegecompanion.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public AppUser signup(@RequestBody AppUser user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user){
        return authService.login(user.getUsername(), user.getPassword());
    }
}
