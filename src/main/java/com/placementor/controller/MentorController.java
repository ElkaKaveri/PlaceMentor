package com.placementor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placementor.model.Experience;
import com.placementor.service.ExperienceService;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    @Autowired
    private ExperienceService experienceService;

    @PostMapping("/add-experience")
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }
}
