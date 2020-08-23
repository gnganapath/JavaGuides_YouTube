package com.webfullstackdev.javaguides.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webfullstackdev.javaguides.model.Employee;
import com.webfullstackdev.javaguides.service.EmployeeService;

//Without service direct calling DAO purpose this import added for getAllEmployeesDAO()
import com.webfullstackdev.javaguides.dao.EmployeeDao;
import com.webfullstackdev.javaguides.exception.ResourceNotFoundException;

@ApiOperation(value = "/api/v1/employees", tags = "Employee Profile Controller", notes = "Employee Profile API")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	//------------------------------------------------------------------------
	@ApiOperation(value = "Get Employee list from swagger", response = Employee.class)
	// get All employee rest API
	// Calling crtl -> service -> Dao.findAll() 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
	 return employeeService.getAllEmployees();
	}
	
	//------------------------------------------------------------------------
	@ApiOperation(value = "add Employee ", response = Employee.class)
	// create new Employee rest API 
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
		//return employeeRepository.save(employee);
	}

	//------------------------------------------------------------------------
	@ApiOperation(value = "Fetch Employee by ID", response = Employee.class)
	// get employee by Id rest API 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable Long id) {
		return employeeService.findEmployeeId(id);
	}

	@ApiOperation(value = "update Employee by ID", response = Employee.class)
	//------------------------------------------------------------------------
	// update  employeId based - findById, Save updated detail - rest API 
	@PutMapping("/employees/{id}")	
	// //Put - update the particular employee
	public ResponseEntity<Employee> updateExitingEmployee(@PathVariable Long id,@RequestBody Employee employee ){
		return employeeService.updateEmpoyeeID(id,employee);
	}

	@ApiOperation(value = "Delete from  Employee list by  employee ID", response = Employee.class)
	 // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteEmployee(@PathVariable Long id) {
       return employeeService.deleteEmployeeService(id);
    }

	//------------------------------------------------------------------------
		
	//get all employee rest API alternate method
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
