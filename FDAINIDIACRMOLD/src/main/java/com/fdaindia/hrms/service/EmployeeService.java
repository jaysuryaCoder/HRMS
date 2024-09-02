package com.fdaindia.hrms.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.response.ReportResponse;

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

	// Fetches a list of report responses containing employee details
	List<ReportResponse> fetchReportResponses();

	// Exports a list of employees to an Excel file
	ByteArrayInputStream exportEmployeesToExcel(List<ReportResponse> employees) throws IOException;
	
	public List<Employee> allEmployee();
}
