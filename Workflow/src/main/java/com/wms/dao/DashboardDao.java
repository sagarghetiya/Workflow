package com.wms.dao;

import java.util.List;

import com.wms.model.WorkflowInstance;

public interface DashboardDao {
	List<WorkflowInstance> getAllWorkflowInstance();
}
