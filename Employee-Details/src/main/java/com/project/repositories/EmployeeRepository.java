package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.EmployeeEntity;
import com.project.entity.EmployeeProfileEntity;

@Component
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	List <EmployeeEntity> findByLoginStatus (String sessionId);
	List<EmployeeEntity> findByEmployeeId(long employeeId);
	List<EmployeeEntity> findByUsername(String username);
	

}
