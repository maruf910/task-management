package com.cardinity.task.controllers;

import com.cardinity.task.dto.ProjectCreateDTO;
import com.cardinity.task.dto.ProjectResponseDTO;
import com.cardinity.task.entities.User;
import com.cardinity.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user) {
        userService.createUser(user);
    }
    @GetMapping
    public List<User> getUser() {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.findByID(id);
    }
}
