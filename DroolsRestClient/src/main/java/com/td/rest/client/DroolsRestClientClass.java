package com.td.rest.client;

import org.springframework.web.client.RestTemplate;

import com.td.rest.data.Customer;

public class DroolsRestClientClass {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/DroolsRestService/app";

	public static void main(String[] args) {
		
		System.out.println("Rest Client Class");
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Return Type is String
		String role = restTemplate.getForObject(REST_SERVICE_URI+"/customer/2", String.class);
		System.out.println("Customer Role Is :: "+role);
		
		// Return Type is Customer Object
		//Customer customer = restTemplate.getForObject(REST_SERVICE_URI+"/customer/3", Customer.class);
		//System.out.println("1..Customer Role Is :: "+customer.getRole());
		
		
	}
	
	

}
