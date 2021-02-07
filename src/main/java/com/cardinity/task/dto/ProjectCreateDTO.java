package com.cardinity.task.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProjectCreateDTO {
	@NotNull
	private String projectName;
	@NotNull
	private String userName;
	
}
