package com.project.json;

import java.time.LocalDate;

public class EmployeeProfileJson {

	private long employeeId;
	private String name;
	LocalDate dob;
	private String address;
	private String phoneNumber;
	private String email;
	private String employeeType;
	private Long managerId;

	private EmployeeJson employee;

	public EmployeeProfileJson(){}
	
	public EmployeeProfileJson(String name, LocalDate dob, String address, String phoneNumber, String email, String employeeType,Long managerId)
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

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public EmployeeJson getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeJson employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeProfileJson [employeeId=" + employeeId + ", name=" + name + ", dob=" + dob + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", employeeType=" + employeeType
				+ ", managerId=" + managerId + ", employee=" + employee + "]";
	}

	

	
	
	
}
