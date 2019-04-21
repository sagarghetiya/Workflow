package com.wms.service;

import java.util.List;

import com.wms.model.Workflow;
import com.wms.model.WorkflowWrapper;

public interface WorkflowService {
	boolean doCreate(WorkflowWrapper workflowWrapper);
	List<Workflow> getWorkflows();
	void deleteWorkflow(String deleteValue);
}
