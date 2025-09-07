package com.paisasense.auth_service.controller;

import com.paisasense.auth_service.dto.LoginRequest;
import com.paisasense.auth_service.entity.User;
import com.paisasense.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }
}





//"Controller endpoints /register aur /login ko expose karta hai."
