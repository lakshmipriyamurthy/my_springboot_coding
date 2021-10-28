package com.pack.HystrixEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Any error occur in the particular server it affects the particular service alone 
@EnableEurekaServer
@SpringBootApplication
public class HystrixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixEurekaServerApplication.class, args);
	}

}
