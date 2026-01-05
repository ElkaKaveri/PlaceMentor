package com.placementor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementor.model.Experience;
import com.placementor.repository.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }
}
