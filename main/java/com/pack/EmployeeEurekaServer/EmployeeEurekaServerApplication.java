package com.pack.EmployeeEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//To make the application to act as eureka server

@EnableEurekaServer
@SpringBootApplication   
public class EmployeeEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEurekaServerApplication.class, args);
	}

}
