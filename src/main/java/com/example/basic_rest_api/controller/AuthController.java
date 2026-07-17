package com.example.basic_rest_api.controller;
import com.example.basic_rest_api.dto.JwtResponse;
import com.example.basic_rest_api.dto.LoginRequest;
import com.example.basic_rest_api.dto.UserRequest;
import com.example.basic_rest_api.model.User;
import com.example.basic_rest_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserRequest request) {
        User savedUser = authService.register(request);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

        JwtResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}