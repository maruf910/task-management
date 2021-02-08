package com.cardinity.task.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

import javax.persistence.*;


@Data
@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
	private long id;
	@Column(nullable = false)
	private String projectName;
	@Column(nullable = false)
	private long projectOwnerId;
}
