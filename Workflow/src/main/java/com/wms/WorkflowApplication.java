package com.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan( basePackages = {"com.wms.model"} )
public class WorkflowApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
	}

}
