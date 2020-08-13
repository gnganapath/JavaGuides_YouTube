package com.webfullstackdev.javaguides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webfullstackdev.javaguides.model.Employee;
import com.webfullstackdev.javaguides.service.EmployeeService;

//Without service direct calling DAO purpose this import added for getAllEmployeesDAO()
import com.webfullstackdev.javaguides.dao.EmployeeDao;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	// Calling crtl -> service -> Dao.findAll() 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
	 return employeeService.getAllEmployees();
	}
	
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
		//return employeeRepository.save(employee);
	}

	
	// Without service direct calling form controller to DAO for fetch JPA findAll()
	// BEGIN ctrl - DAO
	@Autowired
	EmployeeDao employeeRepository;
	@GetMapping("/contrl-employees")
	public List < Employee > getAllEmployeesDAO() {
	  return employeeRepository.findAll();
	}
	// END crtl - DAO

}
