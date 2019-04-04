package com.wms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "workflowinstance")
public class WorkflowInstance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workflowInstanceId; 
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="workflow_id")
	private Workflow workflow;
	
	@OneToMany(mappedBy = "workflowInstance", orphanRemoval = true, cascade=CascadeType.ALL)
    private List<TaskInstance> taskInstanceList = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	private User user;
	
	public Long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public List<TaskInstance> getTaskInstanceList() {
		return taskInstanceList;
	}

	public void setWorkflowInstanceId(Long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public void setTaskInstanceList(List<TaskInstance> taskInstanceList) {
		this.taskInstanceList = taskInstanceList;
	}	
	
}
