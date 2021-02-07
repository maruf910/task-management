package com.cardinity.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardinity.task.dto.ProjectCreateDTO;
import com.cardinity.task.dto.ProjectResponseDTO;
import com.cardinity.task.services.ProjectService;


@RestController
@RequestMapping("project")
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<ProjectResponseDTO> getAllProject() {
		return projectService.getAllProject();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProjectResponseDTO create(@RequestBody ProjectCreateDTO projectCreateDTO) {
		return projectService.createProject(projectCreateDTO);
	}
}
