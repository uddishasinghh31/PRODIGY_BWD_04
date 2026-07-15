package com.example.basic_rest_api.service;
import com.example.basic_rest_api.dto.UserRequest;
import com.example.basic_rest_api.exception.UserNotFoundException;
import com.example.basic_rest_api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService
{
    // In-memory storage: UUID is the key, User is the value.
    private final Map<UUID, User> users = new HashMap<>();

    public User createUser(UserRequest request) {
        User user = new User(
                UUID.randomUUID(),
                request.getName(),
                request.getEmail(),
                request.getAge()
        );

        users.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(UUID id) {
        User user = users.get(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }

        return user;
    }

    public User updateUser(UUID id, UserRequest request) {
        User existingUser = getUserById(id);

        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        existingUser.setAge(request.getAge());

        users.put(id, existingUser);
        return existingUser;
    }

    public void deleteUser(UUID id) {
        getUserById(id);
        users.remove(id);
    }
}
