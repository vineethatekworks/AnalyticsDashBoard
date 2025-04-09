package com.analytics.controllers;

import com.analytics.models.User;
import com.analytics.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email) {
        User loggedInUser = userService.login(email);
        if (loggedInUser == null) {
            return ResponseEntity
                    .badRequest()
                    .body("User not found");
        }
        return ResponseEntity.ok().body("Login successfull");    
        }

    @PutMapping("/profile/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable("id") UUID userId,
                                              @RequestBody Map<String, String> body) {
        String name = body.get("name");
        String bio = body.get("bio");
        User result = userService.updateProfile(userId, name, bio);
        if (result == null) {
            return ResponseEntity
                    .badRequest()
                    .body("User not found or update failed");
        }
        return ResponseEntity.ok().body("updated successfully");   
      }
   }
