package com.example.app.controllers;

import com.example.app.dto.LoginRequest;
import com.example.app.dto.RegisterRequest;
import com.example.app.models.User;
import com.example.app.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: This email is already registered");
        }

        User newUser = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(newUser);

        return ResponseEntity.ok("Successful registration: " + request.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        System.out.println("Incoming login request: " + request.getEmail() + " | " + request.getPassword());

        return userRepository.findByEmail(request.getEmail())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> ResponseEntity.ok("Successful login: " + request.getEmail()))
                .orElseGet(() -> {
                    System.out.println("Login failed: Invalid email or password");
                    return ResponseEntity.badRequest().body("Error: Invalid email or password");
                });
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
