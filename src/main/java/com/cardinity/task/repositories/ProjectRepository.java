package com.cardinity.task.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinity.task.entities.Project;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    public List<Project> findAllByProjectOwnerId(long projectOwnerId);
}
