package com.analytics.controllers;

import com.analytics.models.User;
import com.analytics.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestParam String email) {
		User loggedInUser =userService.login(email) ;
        return ResponseEntity.ok(loggedInUser);
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<User> updateProfile(@PathVariable("id") String userId,
                                              @RequestBody Map<String, String> body) {
        String name = body.get("name");
        String bio = body.get("bio");
        User updated = userService.updateProfile(userId, name, bio);
        return ResponseEntity.ok(updated);
    }
}
