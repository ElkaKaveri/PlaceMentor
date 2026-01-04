package com.placementor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placementor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
