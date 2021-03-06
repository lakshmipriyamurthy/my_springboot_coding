package com.pack.EmployeeConsumerService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerControllerClient {

	// to search the info
	@Autowired
	private DiscoveryClient discoveryClient;

	public void getEmployee() throws RestClientException, IOException {

		List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer"); // name of employee
																								// producer appln
		ServiceInstance serviceInstance = instances.get(0); // get the single service

		String baseUrl = serviceInstance.getUri().toString(); // the instance status is output

		baseUrl = baseUrl + "/employee"; //employee object

		// RestTemplate --> class in spring framework. to execute the url
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
