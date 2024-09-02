package com.fdaindia.hrms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdaindia.hrms.entity.Department;
import com.fdaindia.hrms.response.ApiResponse;
import com.fdaindia.hrms.services.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = { "/add", "/update" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<Map<String, Object>> addOrUpdate(@RequestBody Department department) {
		return ResponseEntity.ok(this.departmentService.addOrUpdate(department));
	}

	@GetMapping(value = "/getById/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getById(@PathVariable("employeeId") Long departmentId) {
		return ResponseEntity.ok(this.departmentService.getDepartmentById(departmentId));
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllEmployees(@RequestBody Department department) {
		return ResponseEntity.ok(this.departmentService.getAll(department));
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long departmentId) {
		this.departmentService.DeleteDepartment(departmentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("department delete successfully !!", true),
				HttpStatus.OK);
	}

}
