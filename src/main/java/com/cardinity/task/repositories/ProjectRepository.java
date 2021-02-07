package com.cardinity.task.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinity.task.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
