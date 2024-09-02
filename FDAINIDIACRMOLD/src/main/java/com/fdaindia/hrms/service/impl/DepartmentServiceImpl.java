package com.fdaindia.hrms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdaindia.hrms.entity.Department;
import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.exceptions.ResourceNotFoundException;
import com.fdaindia.hrms.repository.DepartmentRepo;
import com.fdaindia.hrms.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public Map<String, Object> addOrUpdate(Department department) {
		Map<String, Object> response = new HashMap<>();
		response.put("data", this.departmentRepo.save(department));
		response.put("status", "SUCCESS");
		return response;
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		return this.departmentRepo.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("department", "department Id", departmentId));
	}

	@Override
	public Map<String, Object> getAll(Department department) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("Data", this.departmentRepo.findAll());
		return response;

	}

	@Override
	public void DeleteDepartment(Long departmentId) {
		Department department = this.departmentRepo.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("department", "department Id", departmentId));
		this.departmentRepo.delete(department);
		
	}

}
