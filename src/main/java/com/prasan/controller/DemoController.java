package com.prasan.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prasan.vo.Employee;

import ch.qos.logback.classic.Logger;

@RestController
public class DemoController {
	
	
	private static final Logger logger  = (Logger) LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping("/getTest")
	public String getAPiTest(@RequestParam(value="name",defaultValue="user") String userName)
	{
		logger.debug("Inside getAPiTest");
		return "Hello "+userName+"! Server is up and working now.";
	}
	
	@RequestMapping("/getEmployee")
	public Employee getEmployee()
	{
		logger.debug("Inside getEmployee");
		return new Employee(100,"Prasenjit","IT");
	}
	
	@RequestMapping("/getVersion")
	public String getVersion()
	{
		logger.debug("Inside getVersion");
		 return "Version 1.0-SNAPSHOT";
	}

}
