package com.placementor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.placementor.model.Experience;
import com.placementor.service.ExperienceService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private ExperienceService experienceService;

    // STUDENT DASHBOARD
    @GetMapping("/dashboard")
    public String studentDashboard() {
        return "Welcome Student";
    }

    // VIEW ALL MENTOR EXPERIENCES
    @GetMapping("/experiences")
    public List<Experience> viewAllExperiences() {
        return experienceService.getAllExperiences();
    }
}
