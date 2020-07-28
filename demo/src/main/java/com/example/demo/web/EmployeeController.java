/**
 * 
 */
package com.example.demo.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.Producer;

/**
 * @author bijan
 *
 */
@RestController
public class EmployeeController {

	
	
	
	private static ArrayList<Employee> emplist=new ArrayList<Employee>();
	static {
		emplist.add(new Employee(1,"Ram",24));
		emplist.add(new Employee(1,"Ananda",25));
		emplist.add(new Employee(1,"Balaji",29));
		
		
	}
	
	@RequestMapping(path = "${emplist.path}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployeeList() { 
		
		Collections.sort(emplist, Comparator.comparing(Employee::getName)
	            .thenComparing(Employee::getAge));
		
		return new ResponseEntity<>(emplist, HttpStatus.OK);
	}
	
}
