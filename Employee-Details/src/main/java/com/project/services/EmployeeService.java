package com.project.services;


import java.util.List;

import com.project.json.EmployeeJson;
import com.project.json.EmployeeProfileJson;

public interface EmployeeService {
	public EmployeeProfileJson save(EmployeeProfileJson employee);
	public String login (EmployeeJson employee);
	public EmployeeProfileJson employeeInfo(String authToken);
	public EmployeeProfileJson changepassword(String password,String newpassword, String id);
	public EmployeeProfileJson update(EmployeeProfileJson employee, String id);
	public String logout(String authToken);
	public List<EmployeeProfileJson> managerInfo(String authToken,Long employeeId);
	public EmployeeProfileJson managerInfo(String authToken);
}
