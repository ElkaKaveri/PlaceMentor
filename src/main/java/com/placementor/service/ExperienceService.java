package com.placementor.service;

import java.util.List;
import com.placementor.model.Experience;

public interface ExperienceService {

    Experience addExperience(Experience experience);

    List<Experience> getAllExperiences();
}
