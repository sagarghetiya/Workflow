package com.wms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.model.Task;

@Service("taskService")
public class TaskServiceImpl implements TaskService{

	@Override
	public List<Task> getTasks(Long workflowId) {
		
		return null;
	}
	
}
