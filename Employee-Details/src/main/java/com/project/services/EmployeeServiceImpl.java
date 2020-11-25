package com.project.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.EmployeeEntity;
import com.project.entity.EmployeeProfileEntity;
import com.project.json.EmployeeJson;
import com.project.json.EmployeeProfileJson;
import com.project.repositories.EmployeeProfileRepository;
import com.project.repositories.EmployeeRepository;
import com.project.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeProfileRepository employeeProfileRepository;
	
	@Override
	public EmployeeProfileJson save(EmployeeProfileJson employee) {
		
			EmployeeEntity newEmployee= new EmployeeEntity();
			employeeRepository.save(newEmployee);
			EmployeeProfileEntity employeeProfileEntity = EmployeeUtils.convertEmployeeProfileJsonToEmployeeProfileEntity(employee);
			employeeProfileEntity.setEmployee(newEmployee);
			EmployeeProfileEntity employeeprofileEntity = employeeProfileRepository.save(employeeProfileEntity);
			newEmployee.setEmployeeProfile(employeeprofileEntity);
			employeeRepository.save(newEmployee);
			return EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(employeeprofileEntity);
		
	}
	
	@Override
	public String login(EmployeeJson employee)
	{
		String loginStatus = null;
		Random random = new Random();
		String username = employee.getUsername();
		String password = employee.getPassword();
		List<EmployeeEntity> employeeList = employeeRepository.findByUsername(username);
		
		if(employeeList == null || employeeList.size() == 0)
		{
			return "{ \"result\": \"failed\", \"message\": \"Invalid user " + username + "\"}";
		}
		else
		{
			EmployeeEntity employeeEntity = employeeList.get(0);
			
			if(password.equals(employeeEntity.getPassword()))
			{
				loginStatus = Integer.toString(random.nextInt(500000));
				employeeEntity.setLoginStatus(loginStatus);
				employeeEntity=employeeRepository.save(employeeEntity);
				return "{ \"result\": \"success\", \"message\": \"Login successful\", \"authtoken\":\"" + loginStatus +"\",\"employeeType\":\""+employeeEntity.getEmployeeType()+"\",\"employeeId\":\""+employeeEntity.getEmployeeProfile().getEmployeeId()+"\"}";	
			}
			else
			{
				return "{ \"result\": \"failed\", \"message\": \"Invalid password\" }";
			}
		}

	}
	

	@Override
	public String logout(String authToken)
	{
		List<EmployeeEntity> employeeList = employeeRepository.findByLoginStatus(authToken);
		if (authToken.equals(null) || employeeList == null || employeeList.size() == 0)
		{
			return "{\"result\": \"Invalid LoginStatus\"}";
		}
		else
		{
			EmployeeEntity employeeEntity = employeeList.get(0);
			employeeEntity.setLoginStatus(null);
			employeeEntity = employeeRepository.save(employeeEntity);
			return "{\"result\": \"Logout Successful\"}";
		}
		
	}
	
	@Override
	public EmployeeProfileJson update(EmployeeProfileJson employee, String id) {
		
		EmployeeEntity employeeEntity=employeeRepository.findByLoginStatus(id).get(0);
		EmployeeProfileEntity employeeProfileEntity =employeeEntity.getEmployeeProfile();
		
		if(employeeEntity != null) {
			employeeProfileEntity.setEmployeeId(employeeProfileEntity.getEmployeeId());
			employeeProfileEntity.setName(employee.getName());
			employeeProfileEntity.setDob(employee.getDob());
			employeeProfileEntity.setAddress(employee.getAddress());
			employeeProfileEntity.setPhoneNumber(employee.getPhoneNumber());
			employeeProfileEntity.setEmail(employee.getEmail());
			employeeProfileEntity = employeeProfileRepository.save(employeeProfileEntity);
			return EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(employeeProfileEntity);
		}
		return null;
	
	}
	
	@Override
	public EmployeeProfileJson changepassword(String password,String newpassword, String id) {
		EmployeeEntity employeeEntity = employeeRepository.findByLoginStatus(id).get(0);
		if(employeeEntity != null) {
					if(password.equals(employeeEntity.getPassword())) {
				
				employeeEntity.setPassword(newpassword);
				employeeEntity = employeeRepository.save(employeeEntity);
				return EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(employeeEntity.getEmployeeProfile());	
				}
				else {
					return null;
				}
		}
		return null;
	}

	@Override
	public EmployeeProfileJson employeeInfo(String authToken) {
		List<EmployeeEntity> employeeList = employeeRepository.findByLoginStatus(authToken);
		if (authToken.equals(null) || employeeList == null || employeeList.size() == 0)
		{
			return null;
		}
		else
		{
			EmployeeEntity employeeEntity = employeeRepository.findByLoginStatus(authToken).get(0);
			return EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(employeeEntity.getEmployeeProfile());
		}
	}
	
	@Override
	public List<EmployeeProfileJson> managerInfo(String authToken,Long employeeId) {
		List<EmployeeEntity> employeeList = employeeRepository.findByLoginStatus(authToken);
		 List<EmployeeProfileJson> list=new ArrayList();
		
		if (authToken.equals(null) || employeeList == null || employeeList.size() == 0)
		{
			return null;
		}
		else 
		{
			
				 List<EmployeeProfileEntity> employeesList = employeeProfileRepository.findByManagerId(employeeId);
				
				 Iterator<EmployeeProfileEntity> iterator = employeesList.iterator();
			      while(iterator.hasNext()) {
			    	EmployeeProfileJson lists= EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(  iterator.next());
			   EmployeeProfileJson getLists=new EmployeeProfileJson(lists.getName(), lists.getDob(), lists.getAddress() , lists.getPhoneNumber(), lists.getEmail() , lists.getEmployeeType() ,lists.getManagerId());
			     list.add(getLists);  	  
			      }
		
		}
		return list;
		
		
	}
	
	@Override
	public EmployeeProfileJson managerInfo(String authToken) {
		List<EmployeeEntity> employeeList = employeeRepository.findByLoginStatus(authToken);
		if (authToken.equals(null) || employeeList == null || employeeList.size() == 0)
		{
			return null;
		}
		else
		{
			EmployeeEntity employeeEntity = employeeRepository.findByLoginStatus(authToken).get(0);
			return EmployeeUtils.convertEmployeeProfileEntityToEmployeeProfileJson(employeeEntity.getEmployeeProfile());
		}
	}
	
}
