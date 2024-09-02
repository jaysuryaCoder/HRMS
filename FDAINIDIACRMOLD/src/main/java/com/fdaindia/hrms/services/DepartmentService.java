package com.fdaindia.hrms.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fdaindia.hrms.entity.Department;


public interface DepartmentService {

	// Add a new department or update an existing employee
	Map<String, Object> addOrUpdate(Department department);

	// Get an department by their ID
	Department getDepartmentById(Long departmentId);

	// Get a list of all department
	Map<String, Object> getAll(Department department);

	// Delete an department by their ID
	void DeleteDepartment(Long departmentId);
}
