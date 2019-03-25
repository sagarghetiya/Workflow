package com.wms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.model.WorkflowWrapper;
import com.wms.service.WorkflowService;

@Controller
public class WorkflowController {
	// Just for reference
	/*@GetMapping({"/","/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }*/
	@Autowired
	WorkflowService workflowService;
	
	@GetMapping({"/","/home"})
    public String home() {
        return "home";
    }
	
	@GetMapping({"/createworkflow"})
    public String createworkflow() {
        return "createworkflow";
    }
	
	@PostMapping({"/addWorkflow"})
	public ResponseEntity<Void> addWorkflow(@Valid @RequestBody WorkflowWrapper workflowWrapper, UriComponentsBuilder builder){
		boolean flag = workflowService.doCreate(workflowWrapper);	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
	