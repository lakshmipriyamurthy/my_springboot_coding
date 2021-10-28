package com.pack.EmployeeConsumerService;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class EmployeeConsumerServiceApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(EmployeeConsumerServiceApplication.class, args);
		ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
		consumerControllerClient.getEmployee();
	}

	@Bean
	public ConsumerControllerClient consumerClient()
	{
		return new ConsumerControllerClient();
	}

}
