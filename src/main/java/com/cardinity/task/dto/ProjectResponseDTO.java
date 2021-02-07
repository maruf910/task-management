package com.cardinity.task.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProjectResponseDTO {
	private UUID id;
	private String projectName;
}
