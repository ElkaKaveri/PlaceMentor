package com.placementor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placementor.model.User;
import com.placementor.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    // VIEW ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // VERIFY USER (MENTOR / ALUMNI)
    @PutMapping("/verify/{id}")
    public String verifyUser(@PathVariable Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return "User not found";
        }

        user.setVerified(true);
        userRepository.save(user);

        return "User verified successfully";
    }
}
