package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.wms.model.WorkflowInstance;
import com.wms.service.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@GetMapping({ "/dashboard" })
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping({ "/getallworkflowinstances" })
	public ResponseEntity<List<WorkflowInstance>> getAllWorkflowInstance() {
		List<WorkflowInstance> workflowInstanceList = dashboardService.getAllWorkflowInstance();
		try {
			if (workflowInstanceList == null) {
				return new ResponseEntity<List<WorkflowInstance>>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<List<WorkflowInstance>>(workflowInstanceList,HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
