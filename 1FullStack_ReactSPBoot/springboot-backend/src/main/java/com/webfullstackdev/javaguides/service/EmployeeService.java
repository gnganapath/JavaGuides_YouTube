package com.webfullstackdev.javaguides.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webfullstackdev.javaguides.dao.EmployeeDao;
import com.webfullstackdev.javaguides.exception.ResourceNotFoundException;
import com.webfullstackdev.javaguides.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeRepository;
	
	//------------------------------------------------------------------------
	//get 
	public List<Employee>  getAllEmployees(){
		return employeeRepository.findAll();
	}
	//------------------------------------------------------------------------
	//post
	public  Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	//------------------------------------------------------------------------
	//get with PathVariable
	public ResponseEntity<Employee> findEmployeeId(Long id) {
		Employee employee;
		employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee does not exist wiht id :"+ id) );
		return ResponseEntity.ok(employee);
	}
	//------------------------------------------------------------------------
	//Put - update	
	public ResponseEntity<Employee> updateEmpoyeeID(Long id, Employee updateEmpDetail){
		
		Employee employee;
		
		employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee does not exist wiht id :"+ id) );
		employee.setFullName(updateEmpDetail.getFullName());
		employee.setEmailId(updateEmpDetail.getEmailId());
		employee.setJobRole(updateEmpDetail.getJobRole());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
}

