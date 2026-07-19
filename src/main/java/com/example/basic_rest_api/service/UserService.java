package com.example.basic_rest_api.service;

import com.example.basic_rest_api.dto.UserRequest;
import com.example.basic_rest_api.exception.UserNotFoundException;
import com.example.basic_rest_api.model.User;
import com.example.basic_rest_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User createUser(UserRequest request) {
        User user = new User(
                request.getName().trim(),
                request.getEmail().trim().toLowerCase(),
                request.getAge(),
                request.getPassword()

        );

        return userRepository.save(user);
    }

    @Cacheable("users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = "users", key = "#id")
    public User getUserById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @CachePut(value = "users", key = "#id")
    public User updateUser(UUID id, UserRequest request){
        User user = getUserById(id);

        user.setName(request.getName().trim());
        user.setEmail(request.getEmail().trim().toLowerCase());
        user.setAge(request.getAge());

        return userRepository.save(user);
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(UUID id){
        User user = getUserById(id);
        userRepository.delete(user);
    }
}