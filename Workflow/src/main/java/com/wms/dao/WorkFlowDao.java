package com.wms.dao;

import java.util.List;

import com.wms.model.Workflow;

public interface WorkFlowDao {

	boolean doCreate(Workflow workflow);
	
	List<Workflow> getWorkflows();
}
