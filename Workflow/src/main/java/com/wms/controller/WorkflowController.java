package com.wms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.model.Workflow;
import com.wms.model.WorkflowWrapper;
import com.wms.service.WorkflowService;

@Controller
public class WorkflowController {

	@Autowired
	WorkflowService workflowService;

	@GetMapping({ "/", "/home" })
	public String home() {
		return "dashboard";
	}

	@GetMapping({ "/createworkflow" })
	public String createWorkflow() {
		return "createworkflow";
	}

	@GetMapping({ "/listworkflow" })
	public String updateWorkflow() {
		return "listWorkflow";
	}

	@PostMapping({ "/addWorkflow" })
	public ResponseEntity<Void> addWorkflow(@Valid @RequestBody WorkflowWrapper workflowWrapper,
			UriComponentsBuilder builder) {
		boolean flag = workflowService.doCreate(workflowWrapper);
		if (flag)
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping({ "/getWorkflows" })
	public ResponseEntity<List<Workflow>> getWorkflows() {
		try {
			List<Workflow> workflowList = workflowService.getWorkflows();
			if (workflowList == null) {
				return new ResponseEntity<List<Workflow>>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return ResponseEntity.ok().body(workflowList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping({"/deleteWorkflow/{deletevalue}"})
	public ResponseEntity<Void> deleteWorkflow(@PathVariable(value = "deletevalue") String deleteValue){
		workflowService.deleteWorkflow(deleteValue);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
