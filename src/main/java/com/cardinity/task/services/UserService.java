package com.cardinity.task.services;

import com.cardinity.task.entities.User;
import com.cardinity.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User findByID(long id) {
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public long getUUIDbyUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if(Objects.isNull(user)) return 0;
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

    public String getUserNameByUUID(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get().getUserName();
        else return "Not Found";
    }
}
