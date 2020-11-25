package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.json.EmployeeJson;
import com.project.json.EmployeeProfileJson;
import com.project.services.EmployeeService;

@RestController
@RequestMapping("/my-app")
@CrossOrigin(origins="*")
public class EmployeeData {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/employee", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeProfileJson registerUser(@RequestBody EmployeeProfileJson employee ){
		return employeeService.save(employee);
	}
	
	@PostMapping(value="/employee/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody EmployeeJson employee) {
		return employeeService.login(employee);
	}
	
	@GetMapping(value="/employee/profile", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeProfileJson employeeInfo(@RequestHeader(name="auth-token") String authToken) {
		return employeeService.employeeInfo(authToken);
	}
	
	@PutMapping(value="/employee/logout", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutUser(@RequestHeader(name="auth-token") String authToken) {
		return employeeService.logout(authToken);
	}
	
	@PostMapping(value="/employee/pass",  produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeProfileJson changepassword( @RequestParam(name="oldpassword") String password,@RequestParam(name="newpassword") String newpassword,@RequestHeader(name="auth-token") String authToken) {
		return employeeService.changepassword(password,newpassword, authToken);
	}
	
	@PutMapping(value="/employee/uprofile", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeProfileJson update(@RequestBody EmployeeProfileJson user, @RequestHeader(name="auth-token") String authToken) { 
		return employeeService.update(user,authToken); 
	}
	
	@GetMapping(value="/employee/manager/{employeeId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeProfileJson> managerInfo(@RequestHeader(name="auth-token") String authToken, @PathVariable(name = "employeeId") long employeeId) {
		return employeeService.managerInfo(authToken,employeeId);
	}
	
	@GetMapping(value="/employee/managerProfile", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeProfileJson managerInfo(@RequestHeader(name="auth-token") String authToken) {
		return employeeService.managerInfo(authToken);
	}
	
	 
	

}
