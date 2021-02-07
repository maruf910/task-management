package com.cardinity.task.services;

import com.cardinity.task.dto.FetchProjectDTO;
import com.cardinity.task.dto.ProjectCreateDTO;
import com.cardinity.task.exceptions.ExceptionHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    @Autowired
    UserService userService;

    private static final int maxProjectNameLength = 200;

    public boolean isValidUser(String userName) {
        if(userName==null || userName.isEmpty()) return false;
        if(!userService.isUserExist(userName)) return false;
        return true;
    }

    public void validateProjectCreateDto(ProjectCreateDTO projectCreateDTO) {
        validateUserName(projectCreateDTO.getUserName());
        if(projectCreateDTO.getProjectName().isEmpty()) {
            throw new ExceptionHolders.InvalidRequestException("Project Name cannot be empty.");
        }
        if(projectCreateDTO.getProjectName().length()>maxProjectNameLength) {
            throw new ExceptionHolders.InvalidRequestException("Project Name is too large, maximum length can be 200");
        }
    }

    public void validateUserName(String username) {
        if(!isValidUser(username)) {
            throw new ExceptionHolders.InvalidRequestException("Invalid Username Given.");
        }
    }

}
