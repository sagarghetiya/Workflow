package com.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dao.DashboardDao;
import com.wms.model.WorkflowInstance;

@Service("DashboardService")
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	DashboardDao dashboardDao;
	
	@Override
	public List<WorkflowInstance> getAllWorkflowInstance(){
		return dashboardDao.getAllWorkflowInstance();
	}
}
