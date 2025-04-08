package com.analytics.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.models.User;
import com.analytics.repos.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Login: Fetch user by email
    public User login(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return optionalUser.get();
    }

    // Update profile by ID
    public User updateProfile(String userId, String name, String bio) {
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(userId));

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();
        user.setFullName(name);
        user.setBio(bio);

        return userRepository.save(user); // save and return updated user
    }
}
