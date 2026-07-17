
package com.example.basic_rest_api.service;
import com.example.basic_rest_api.dto.JwtResponse;
import com.example.basic_rest_api.dto.LoginRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.basic_rest_api.security.JwtService;
import com.example.basic_rest_api.dto.UserRequest;
import com.example.basic_rest_api.model.User;
import com.example.basic_rest_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User register(UserRequest request) {

        User user = new User(
                request.getName().trim(),
                request.getEmail().trim().toLowerCase(),
                request.getAge(),
                passwordEncoder.encode(request.getPassword())
        );

        return userRepository.save(user);
    }
    public JwtResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new JwtResponse(token);
    }
}