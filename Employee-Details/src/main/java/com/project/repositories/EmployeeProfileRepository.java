package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.entity.EmployeeProfileEntity;

@Component
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfileEntity, Long>{
	List<EmployeeProfileEntity> findByEmployeeId(long employeeId);
	List<EmployeeProfileEntity> findByManagerId(Long managerId);
	

}
