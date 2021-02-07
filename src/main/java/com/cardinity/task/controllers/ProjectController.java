package com.cardinity.task.controllers;

import java.util.List;

import com.cardinity.task.dto.FetchProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cardinity.task.dto.ProjectCreateDTO;
import com.cardinity.task.dto.ProjectResponseDTO;
import com.cardinity.task.services.ProjectService;


@RestController
@RequestMapping("project")
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping("/{username}")
	public ResponseEntity<List<ProjectResponseDTO>> getAllProject(@PathVariable String username) {
		return new ResponseEntity<>(projectService.getAllProject(username), HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProjectResponseDTO> create(@RequestBody ProjectCreateDTO projectCreateDTO) {
		return new ResponseEntity<>(projectService.createProject(projectCreateDTO), HttpStatus.OK);
	}
}
