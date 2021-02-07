package com.cardinity.task.services;

import com.cardinity.task.entities.User;
import com.cardinity.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
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
        User user = userRepository.findByUserName(userName);
        if(Objects.isNull(user)) return null;
        else return user.getId();
    }

    public boolean isUserExist(String userName) {
        User user = userRepository.findByUserName(userName);
        if(Objects.isNull(user)) return false;
        return true;
    }

    public boolean isAdmin(String userName) {
        User user = userRepository.findByUserName(userName);
        if(user.getRole().equals("admin")) return true;
        return false;
    }

    public String getUserNameByUUID(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get().getUserName();
        else return "Not Found";
    }
}
