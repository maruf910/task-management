package com.cardinity.task.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.cardinity.task.dto.FetchProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinity.task.dto.ProjectCreateDTO;
import com.cardinity.task.dto.ProjectResponseDTO;
import com.cardinity.task.entities.Project;
import com.cardinity.task.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	UserService userService;
	@Autowired
	ModelMapper mapper;
	@Autowired
	ValidationService validationService;
	
	public List<ProjectResponseDTO> getAllProject(String username) {
		validationService.validateUserName(username);
		List<Project> allProject = new ArrayList<>();
		if(userService.isAdmin(username)) {
			allProject = projectRepository.findAll();
		} else {
			long userUUID = userService.getUUIDbyUserName(username);
			allProject = projectRepository.findAllByProjectOwnerId(userUUID);
		}
		return allProject.stream()
		.map(entity -> convertProjectToProjectResponseDTO(entity))
		.collect(Collectors.toList());
	}
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	public ProjectResponseDTO createProject(ProjectCreateDTO dto) {
		validationService.validateProjectCreateDto(dto);
		Project project = mapper.map(dto, Project.class);
		project.setProjectOwnerId(getCurrentUserId(dto.getUserName()));
		Project retProject = projectRepository.save(project);
		return convertProjectToProjectResponseDTO(retProject);
	}
	
	
	/* Private classes */
	private long getCurrentUserId(String userName) {
		return userService.getUUIDbyUserName(userName);
	}

	private ProjectResponseDTO convertProjectToProjectResponseDTO(Project project) {
		ProjectResponseDTO dto = new ProjectResponseDTO();
		dto.setProjectName(project.getProjectName());
		dto.setOwnerUserName(userService.getUserNameByUUID(project.getProjectOwnerId()));
		dto.setProjectOwnerId(project.getProjectOwnerId());
		return dto;
	}
}
