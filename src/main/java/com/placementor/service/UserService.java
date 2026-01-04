package com.placementor.service;

import java.util.List;
import com.placementor.model.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}
