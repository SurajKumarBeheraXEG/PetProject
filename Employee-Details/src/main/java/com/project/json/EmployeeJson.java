package com.project.json;

public class EmployeeJson {
	private long employeeId;
	private String username;
	private String password;
	private String employeeType;
	private String loginStatus;
	private EmployeeProfileJson employeeProfile;
	
	public EmployeeJson() {}
	
	
	public EmployeeJson( String username, String password, String employeeType, String loginStatus) {
		super();
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
		this.loginStatus = loginStatus;
	}
	
	
	public EmployeeJson(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public EmployeeJson(String username, String password, String employeeType) {
		super();
		this.username = username;
		this.password = password;
		this.employeeType = employeeType;
	}


	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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
	public EmployeeProfileJson getEmployeeProfile() {
		return employeeProfile;
	}
	public void setEmployeeProfile(EmployeeProfileJson employeeProfile) {
		this.employeeProfile = employeeProfile;
	}


	@Override
	public String toString() {
		return "EmployeeJson [employeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", employeeType=" + employeeType + ", loginStatus=" + loginStatus + ", employeeProfile="
				+ employeeProfile + "]";
	}
	
	
	
}
