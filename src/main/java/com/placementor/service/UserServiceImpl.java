package com.placementor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placementor.model.User;
import com.placementor.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // AUTO VERIFY STUDENT & ADMIN
        if (user.getRole().equals("STUDENT") || user.getRole().equals("ADMIN")) {
            user.setVerified(true);
        } else {
            // MENTOR / ALUMNI
            user.setVerified(false);
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
