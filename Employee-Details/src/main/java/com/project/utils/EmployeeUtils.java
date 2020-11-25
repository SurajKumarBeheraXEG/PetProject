package com.project.utils;

import com.project.entity.EmployeeEntity;
import com.project.entity.EmployeeProfileEntity;
import com.project.json.EmployeeJson;
import com.project.json.EmployeeProfileJson;

public class EmployeeUtils {
	public static EmployeeProfileEntity convertEmployeeProfileJsonToEmployeeProfileEntity(EmployeeProfileJson employeeProfileJson)
	{
		return new EmployeeProfileEntity(employeeProfileJson.getName(), employeeProfileJson.getDob(), employeeProfileJson.getAddress(),
				employeeProfileJson.getPhoneNumber(), employeeProfileJson.getEmail(),employeeProfileJson.getEmployeeType(),employeeProfileJson.getManagerId());
	}
	
	public static EmployeeProfileJson convertEmployeeProfileEntityToEmployeeProfileJson(EmployeeProfileEntity employeeProfileEntity)
	{
		return new EmployeeProfileJson(employeeProfileEntity.getName(), employeeProfileEntity.getDob(), employeeProfileEntity.getAddress(),
				employeeProfileEntity.getPhoneNumber(), employeeProfileEntity.getEmail(), employeeProfileEntity.getEmployeeType(),employeeProfileEntity.getManagerId());
	}
	
	public static EmployeeEntity convertEmployeeJsonToEmployeeEntity(EmployeeJson employeeJson)
	{
		return new EmployeeEntity(employeeJson.getUsername(), employeeJson.getPassword(), employeeJson.getEmployeeType(), employeeJson.getLoginStatus());
		
	}
	
	public static EmployeeJson convertEmployeeEntityToEmployeeJson(EmployeeEntity employeeEntity)
	{
		return new EmployeeJson(employeeEntity.getUsername(), employeeEntity.getPassword(), employeeEntity.getEmployeeType(), employeeEntity.getLoginStatus());
		
	}
	
}
