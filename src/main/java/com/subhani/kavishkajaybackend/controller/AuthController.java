package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {

        this.authService = authService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@Valid @RequestBody User user) {
//        return ResponseEntity.ok(authService.register(user));
//    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        // Call the service class to handle the registration logic
        user.setRole("customer");
        Map<String, String> response = authService.register(user);

        // Return a response with a message as JSON
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        try {
            String token = authService.login(email, password);  // Call the service method to authenticate
            return ResponseEntity.ok(token);  // Return the JWT token on successful authentication
        } catch (RuntimeException ex) {
            // Handle different error cases and return appropriate status
            if (ex.getMessage().equals("User not found") || ex.getMessage().equals("Invalid password")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(ex.getMessage());  // Return 401 with the error message
            } else {
                // For other exceptions, return a generic internal server error
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An error occurred during login");
            }
        }
    }
}
