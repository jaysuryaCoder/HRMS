package com.fdaindia.hrms.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.fdaindia.hrms.entity.Employee;

public interface EmployeeService {

	// Add a new employee or update an existing employee
	Map<String, Object> addOrUpdate(Employee employee);

	// Get an employee by their ID
	Employee getEmployeeById(Long employeeId);

	// Get a list of all employees
	public List<Employee> getAll(Pageable pageable);

	// Delete an employee by their ID
	void deleteEmployee(Long categoryId);

	// Search an employee
	public List<Employee> searchEmployee(String query, Pageable pageable);

	// Get Employee By Email
	Employee getEmployeeByEmail(String email);

	List<Employee> allEmployee();
}
