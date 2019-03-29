package com.wms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@NotBlank
	private String taskName;
	
	@NotBlank
	private String taskDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadLine;
	
	@Enumerated(EnumType.STRING)
	private ActionEnum action;
	
	@NotNull
	private Integer sequence;
	
	@Enumerated(EnumType.STRING)
	private NotificationStatusEnum notificationStatus;
	
	@ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

	public Long getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	@JsonFormat(pattern = "dd/MM/yyyy h:mm aa", timezone="Asia/Kolkata")
	public Date getDeadLine() {
		return deadLine;
	}

	public ActionEnum getAction() {
		return action;
	}

	public Integer getSequence() {
		return sequence;
	}

	public NotificationStatusEnum getNotificationStatus() {
		return notificationStatus;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public void setNotificationStatus(NotificationStatusEnum notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
}
