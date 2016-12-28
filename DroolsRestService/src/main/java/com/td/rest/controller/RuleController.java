package com.td.rest.controller;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.td.rest.data.Customer;

@RestController
public class RuleController {
	
	@RequestMapping(value="/customer/1", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String Customer1() {
		
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
		Customer customer = new Customer();
    	customer.setCustomerId("customer1");
    	
    	kSession.insert(customer);
    	kSession.fireAllRules();
    	
		System.out.println("RuleController:::Customer Role Is :: "+customer.getRole());
    	
    	return customer.getRole();
	}
	
	@RequestMapping(value="/customer/2", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String Customer2() {
		
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
		Customer customer = new Customer();
    	customer.setCustomerId("customer2");
    	
    	kSession.insert(customer);
    	kSession.fireAllRules();
    	
		System.out.println("RuleController:::Customer Role Is :: "+customer.getRole());
    	
    	return customer.getRole();
	}
	
	@RequestMapping(value="/customer/3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> Customer3() {
		
		System.out.println("Rule Controller : Customer1 method");
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
		Customer customer = new Customer();
    	customer.setCustomerId("customer1");
    	
    	kSession.insert(customer);
    	kSession.fireAllRules();

		System.out.println("RuleController:::Customer Role Is :: "+customer.getRole());
    	
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
		
}
