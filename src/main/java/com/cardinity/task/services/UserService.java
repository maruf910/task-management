package com.cardinity.task.services;

import com.cardinity.task.entities.User;
import com.cardinity.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UUID getUUIDbyUserName(String userName) {
        return userRepository.findByUserName(userName).getId();
    }
}
