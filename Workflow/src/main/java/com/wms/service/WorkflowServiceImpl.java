package com.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dao.WorkFlowDao;
import com.wms.model.Task;
import com.wms.model.Workflow;
import com.wms.model.WorkflowWrapper;

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	WorkFlowDao workflowDao;

	@Override
	public boolean doCreate(WorkflowWrapper workflowWrapper) {
		try {
			Workflow workflow = new Workflow();
			workflow.setTaskList(workflowWrapper.getTaskList());
			workflow.setWorkflowDescription(workflowWrapper.getWorkflowDescription());
			workflow.setWorkflowName(workflowWrapper.getWorkflowName());
			Integer sequence = 1;
			// Since it is a bi-directional mapping we need to set workflow in task and task
			// in workflow
			for (Task task : workflowWrapper.getTaskList()) {
				task.setWorkflow(workflow);
				task.setSequence(sequence++);
			}
			workflowDao.doCreate(workflow);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Workflow> getWorkflows() {
		List<Workflow> workflowList = null;
		try {
			workflowList = workflowDao.getWorkflows();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		if(workflowList!=null && !workflowList.isEmpty()) {
			return workflowList;
		}
		return null;
	}
}
