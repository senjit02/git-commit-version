package com.prasan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//import org.omg.CORBA.portable.InputStream;
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
		 //return "Version 1.0-SNAPSHOT";
		return readGitProperties();
	}
	
	
	
	private String readGitProperties() {
	    ClassLoader classLoader = getClass().getClassLoader();
	    InputStream inputStream = classLoader.getResourceAsStream("git.properties");
	    try {
	        return readFromInputStream(inputStream);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Version information could not be retrieved";
	    }
	}
	private String readFromInputStream(InputStream inputStream)
	throws IOException {
	    StringBuilder resultStringBuilder = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            resultStringBuilder.append(line).append("\n");
	        }
	    }
	    return resultStringBuilder.toString();
	}

}
