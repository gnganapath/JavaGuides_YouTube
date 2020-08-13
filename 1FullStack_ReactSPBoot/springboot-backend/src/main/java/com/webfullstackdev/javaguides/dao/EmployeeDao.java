package com.webfullstackdev.javaguides.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webfullstackdev.javaguides.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
