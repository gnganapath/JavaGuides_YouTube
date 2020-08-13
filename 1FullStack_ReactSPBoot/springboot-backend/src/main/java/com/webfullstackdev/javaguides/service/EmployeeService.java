package com.webfullstackdev.javaguides.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webfullstackdev.javaguides.dao.EmployeeDao;
import com.webfullstackdev.javaguides.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeRepository;
	
	public List<Employee>  getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	
	public  Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
