package com.placementor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.placementor.model.Experience;
import com.placementor.model.User;
import com.placementor.repository.UserRepository;
import com.placementor.service.ExperienceService;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-experience")
    public Object addExperience(@RequestBody Experience experience,
                                Authentication authentication) {

        String email = authentication.getName();
        User mentor = userRepository.findByEmail(email);

        if (!mentor.isVerified()) {
            return "Mentor account not verified by admin";
        }

        experience.setMentorEmail(email);
        return experienceService.addExperience(experience);
    }
}
