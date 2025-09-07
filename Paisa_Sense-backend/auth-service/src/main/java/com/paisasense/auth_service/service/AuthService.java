package com.paisasense.auth_service.service;

import com.paisasense.auth_service.entity.User;
import com.paisasense.auth_service.repository.UserRepository;
import com.paisasense.auth_service.security.JwtUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor injection - sab dependencies inject ho rahe hain
    public AuthService(UserRepository userRepository, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder; // SecurityConfig se inject hoga
    }

    public String register(User user) {
        // Pehle check karte hain user already exist toh nahi karta
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Password encrypt karke save karte hain
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // JWT token return karte hain
        return jwtUtil.generateToken(user.getUsername());
    }

    public String login(String username, String password) {
        // Username se user find karte hain
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Password match check karte hain (encrypted password se)
        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}

/*
 * Flow explanation:
 * 1. Register: Username/Email duplicate check -> Password encrypt -> Save -> JWT return
 * 2. Login: User find -> Password verify -> JWT return
 * 3. JWT token client ko send hota hai authentication ke liye
 */