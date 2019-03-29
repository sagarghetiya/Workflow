package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wms.model.Task;
import com.wms.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping({"getTasks"})
	public ResponseEntity<List<Task>> getTasks(@RequestBody Long workflowId) {
		List<Task> taskList = taskService.getTasks(workflowId);
		try {
			if (taskList == null) {
				return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return ResponseEntity.ok().body(taskList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
