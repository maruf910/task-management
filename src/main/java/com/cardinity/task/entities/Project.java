package com.cardinity.task.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="project")
public class Project {
	@Id
    @GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(name = "project_name", nullable = false)
	private String projectName;
	@Column(name = "project_owner_id", nullable = false)
	private UUID projectOwnerId;
}
