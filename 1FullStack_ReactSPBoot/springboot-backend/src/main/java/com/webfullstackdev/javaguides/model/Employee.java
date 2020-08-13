package com.webfullstackdev.javaguides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employess")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="job_role")
	private String jobRole;
	
	@Column(name="email_id")
	private String emailId;
	
	// whenever create parameter constructor, empty constructor need, Hibernate JPA expects proxy to be some empty
	public Employee() {
		
	}
	
	public Employee(String fullName, String jobRole, String emailId) {
		super();
		this.fullName = fullName;
		this.jobRole = jobRole;
		this.emailId = emailId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
