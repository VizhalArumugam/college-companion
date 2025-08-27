package com.collegecompanion.service;

import com.collegecompanion.model.AppUser;
import com.collegecompanion.repository.AppUserRepository;
import com.collegecompanion.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AppUserRepository  appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(AppUserRepository userRepository) {
        this.appUserRepository = userRepository;
    }

    public AppUser register(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // hash password
        return appUserRepository.save(user);
    }

    public String login(String username, String rawPassword) {
        return appUserRepository.findByUsername(username)
                .filter(u -> passwordEncoder.matches(rawPassword, u.getPassword()))
                .map(u -> JwtUtil.generateToken(u.getUsername(),u.getRole())) // return token
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
}
