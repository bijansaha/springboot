package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.Producer;

@RestController
@RequestMapping(value = "${emp.producer.path}")
public class EmployeeProducer {

	
	  @Autowired
	  private Producer producer;
	    
	    @GetMapping(value = "${emp.producer.msg.path}")
	    public String postJsonMessage(@RequestParam("id") String id){
	    	producer.sendMessage(new Employee(1,"Ram",35));
	        return "Message published successfully";
	    }
}
