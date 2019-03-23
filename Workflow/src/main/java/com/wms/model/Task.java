package com.wms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	
	@NotBlank
	private String taskName;
	
	@NotBlank
	private String taskDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadLine;
	
	
}
