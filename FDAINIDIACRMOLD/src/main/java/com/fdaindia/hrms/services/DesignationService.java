package com.fdaindia.hrms.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fdaindia.hrms.entity.Designation;


public interface DesignationService {

	// Add a new Designation or update an existing employee
	Map<String, Object> addOrUpdate(Designation designation);

	// Get an Designation by their ID
	Designation getDesignationById(Long DesignationId);

	// Get a list of all Designation
	Map<String, Object> getAll(Designation designation);

	// Delete an Designation by their ID
	void DeleteDesignation(Long DesignationId);

	List<Designation> getAllDesignationsByDepartmentId(Long departmentId);
	
}
