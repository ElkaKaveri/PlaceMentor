package com.placementor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placementor.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
