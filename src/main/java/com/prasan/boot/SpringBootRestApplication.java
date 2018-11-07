package com.prasan.boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import ch.qos.logback.classic.Logger;

@ComponentScan({"com.prasan.controller","com.prasan.routebuilder"})
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootRestApplication {

	private static final Logger logger  = (Logger) LoggerFactory.getLogger(SpringBootRestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
		logger.debug("Spring boot container has been started....");
	}
}
