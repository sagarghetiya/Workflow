package com.wms.model;

import java.util.List;

public class WorkflowWrapper {

	public String workflowName;
	public String workflowDescription;
	public List<Task> taskList;
	public List<UserGroup> userGroupList;

	public String getWorkflowName() {
		return workflowName;
	}

	public String getWorkflowDescription() {
		return workflowDescription;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public void setWorkflowDescription(String workflowDescription) {
		this.workflowDescription = workflowDescription;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<UserGroup> getUserGroupList() {
		return userGroupList;
	}

	public void setUserGroupList(List<UserGroup> userGroupList) {
		this.userGroupList = userGroupList;
	}
	
}
