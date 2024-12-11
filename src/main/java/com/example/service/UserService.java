package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository userRepository;

    public User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.create(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, String newName) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setName(newName);
            return userRepository.update(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public List<User> getUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getActiveUsers() {
        return userRepository.findActiveUsers();
    }
}