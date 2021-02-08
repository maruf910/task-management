package com.cardinity.task.repositories;

import com.cardinity.task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
