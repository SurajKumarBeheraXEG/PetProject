package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_CREDENTIALS")
public class EmployeeEntity {
	@GeneratedValue
	@Id
	@Column(name="EMPLOYEE_UNIQUE_ID")
	private long employeeId;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="EMPLOYEE_TYPE")
	private String employeeType;
	
	@Column(name="LOGIN_STATUS")
	private String loginStatus;
	

	@OneToOne(targetEntity=EmployeeProfileEntity.class)
	private EmployeeProfileEntity employeeProfile;
	
	
	public EmployeeEntity() {}
	
	
	
	public EmployeeEntity(String username, String password, String employeeType) {
		super();
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
	}
	
	
	public EmployeeEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public EmployeeEntity( String username, String password, String employeeType, String loginStatus) {
		super();
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
		this.loginStatus = loginStatus;
		
	}

	public long getUserId() {
		return employeeId;
	}

	public void setUserId(long userId) {
		this.employeeId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public EmployeeProfileEntity getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(EmployeeProfileEntity employeeProfile) {
		this.employeeProfile = employeeProfile;
	}



	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", employeeType=" + employeeType + ", loginStatus=" + loginStatus + ", employeeProfile="
				+ employeeProfile + "]";
	}

	
	
	
	
}
