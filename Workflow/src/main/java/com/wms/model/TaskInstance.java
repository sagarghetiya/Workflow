package com.wms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="taskinstance")
public class TaskInstance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskInstanceId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date taskInstaceDeadLine;

	private String status;

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="task_id")
	private Task task;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="workflow_instance_id")
	private WorkflowInstance workflowInstance;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getTaskInstanceId() {
		return taskInstanceId;
	}

	public Task getTask() {
		return task;
	}

	public WorkflowInstance getWorkflowInstance() {
		return workflowInstance;
	}

	public void setTaskInstanceId(Long taskInstanceId) {
		this.taskInstanceId = taskInstanceId;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	@JsonFormat(pattern = "dd/MM/yyyy h:mm aa", timezone="Asia/Kolkata")
	public Date getTaskInstaceDeadLine() {
		return taskInstaceDeadLine;
	}

	public void setTaskInstaceDeadLine(Date taskInstaceDeadLine) {
		this.taskInstaceDeadLine = taskInstaceDeadLine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
