package com.wms.service;

import java.util.List;

import com.wms.model.Task;

public interface TaskService {
	List<Task> getTasks(Long workflowId);
}
