package com.wms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dao.WorkFlowDao;
import com.wms.model.Workflow;
import com.wms.model.WorkflowWrapper;

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService{
	
	@Autowired
	WorkFlowDao workflowDao;
	
	public boolean doCreate(WorkflowWrapper workflowWrapper) {
		Workflow workflow = new Workflow();
		workflow.setTaskList(workflowWrapper.getTaskList());
		workflow.setWorkflowDescription(workflowWrapper.getWorkflowDescription());
		workflow.setWorkflowName(workflowWrapper.getWorkflowName());
		workflowDao.doCreate(workflow);
		return true;
	}
}
