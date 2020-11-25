package com.project.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEEDETAILS")
public class EmployeeProfileEntity{
 	@GeneratedValue
	@Id
	@Column(name="EMPLOYEEID")
	private long employeeId;

	@Column(name="NAME")
	private String name;

	@Column(name="DOB")
	LocalDate dob;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="PHONENUMBER")
	private String phoneNumber;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="EMPLOYEE_TYPE")
	private String employeeType;
	
	
	@Column(name="MANAGER_ID")
	private Long managerId;
	
	@OneToOne(targetEntity = EmployeeEntity.class)
	private EmployeeEntity employee;
	
	public EmployeeProfileEntity(){}

	public EmployeeProfileEntity(String name, LocalDate dob, String address, String phoneNumber, String email,String employeeType,Long managerId)
	{
		super();
		this.name=name;
		this.dob=dob;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.employeeType=employeeType;
		this.managerId=managerId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long empId) {
		this.employeeId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeProfileEntity [employeeId=" + employeeId + ", name=" + name + ", dob=" + dob + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", employeeType=" + employeeType
				+ ", managerId=" + managerId + ", employee=" + employee + "]";
	}

	


	
	
}