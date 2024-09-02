package com.fdaindia.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdaindia.hrms.config.AppConstants;
import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.exceptions.ResourceNotFoundException;
import com.fdaindia.hrms.repository.EmployeeRepo;
import com.fdaindia.hrms.response.ApiResponse;
import com.fdaindia.hrms.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping(value = { "/add", "/update" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<Map<String, Object>> addOrUpdate(@RequestBody Employee employee) {
		return ResponseEntity.ok(this.employeeService.addOrUpdate(employee));
	}

	@GetMapping(value = "/getById/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@PathVariable("employeeId") Long employeeId) {
		return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllEmployees(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		try {
			List<Employee> employees = employeeService.getAll(PageRequest.of(pageNumber, pageSize));
			return ResponseEntity.ok(employees);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch employees.");
		}
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long employeeId) {
		this.employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("employee delete successfully !!", true), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchEmployee(@RequestParam("query") String query,
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE) int pageSize) {
		try {
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			List<Employee> employees = employeeService.searchEmployee(query, pageable);
			return ResponseEntity.ok(employees);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while searching for employees.");
		}
	}

	@GetMapping("/getByEmail")
	public ResponseEntity<?> getEmployeeByEmail(@RequestParam("email") String email) {
		try {
			Employee employee = employeeService.getEmployeeByEmail(email);
			return ResponseEntity.ok(employee);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while fetching the employee.");
		}
	}
	
}
