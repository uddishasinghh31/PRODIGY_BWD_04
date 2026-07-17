package com.example.basic_rest_api.service;

import com.example.basic_rest_api.dto.UserRequest;
import com.example.basic_rest_api.exception.UserNotFoundException;
import com.example.basic_rest_api.model.User;
import com.example.basic_rest_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest request) {
        User user = new User(
                request.getName().trim(),
                request.getEmail().trim().toLowerCase(),
                request.getAge(),
                request.getPassword()

        );

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUser(UUID id, UserRequest request) {
        User user = getUserById(id);

        user.setName(request.getName().trim());
        user.setEmail(request.getEmail().trim().toLowerCase());
        user.setAge(request.getAge());

        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}