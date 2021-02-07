package com.cardinity.task.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.cardinity.task.repositories.UserRepository;
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
	
	public List<ProjectResponseDTO> getAllProject() {
		List<Project> allProject = projectRepository.findAll();
		return allProject.stream()
		.map(entity -> mapper.map(entity, ProjectResponseDTO.class))
		.collect(Collectors.toList());
	}
	public ProjectResponseDTO createProject(ProjectCreateDTO dto) {
		Project project = mapper.map(dto, Project.class);
		project.setProjectOwnerId(getCurrentUserId(dto.getUserName()));
		return mapper.map(projectRepository.save(project), ProjectResponseDTO.class);
	}
	
	
	/* Private classes */
	private UUID getCurrentUserId(String userName) {
		return userService.getUUIDbyUserName(userName);
	}
}
