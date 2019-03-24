package com.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkflowController {
	// Just for reference
	/*@GetMapping({"/","/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }*/
	
	@GetMapping({"/","/home"})
    public String home() {
        return "home";
    }
	
	@GetMapping({"/createworkflow"})
    public String createworkflow() {
        return "createworkflow";
    }
	
	
	
}
