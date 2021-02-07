package com.cardinity.task.repositories;

import com.cardinity.task.entities.Project;
import com.cardinity.task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserName(String userName);
}
