package com.wms.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "workflow")
public class Workflow {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long workflowId;
	
	@NotBlank
	private String workflowName;
	
	@NotBlank
	private String workflowDescription;
	
	
	private ArrayList<Task> taskList;
}
