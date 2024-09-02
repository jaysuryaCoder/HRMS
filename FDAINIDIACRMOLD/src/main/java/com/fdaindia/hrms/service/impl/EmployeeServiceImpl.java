package com.fdaindia.hrms.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fdaindia.hrms.entity.DeletedEmployee;
import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.exceptions.ResourceNotFoundException;
import com.fdaindia.hrms.repository.DeletedEmployeeRepo;
import com.fdaindia.hrms.repository.EmployeeRepo;
import com.fdaindia.hrms.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private DeletedEmployeeRepo deletedEmployeeRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Map<String, Object> addOrUpdate(Employee employee) {
		Map<String, Object> response = new HashMap<>();
		response.put("data", this.employeeRepo.save(employee));
		response.put("status", "SUCCESS");
		return response;

	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return this.employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "employee Id", employeeId));
	}

	@Override
	public List<Employee> getAll(Pageable pageable) {
		Page<Employee> pageEmployee = employeeRepo.findAll(pageable);
		return pageEmployee.getContent();
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "employee Id", employeeId));

		DeletedEmployee deletedEmployee = modelMapper.map(employee, DeletedEmployee.class);
		deletedEmployee.setOriginalId(employee.getId());
		deletedEmployee.setDeletionTime(LocalDateTime.now());

		deletedEmployeeRepo.save(deletedEmployee);
		employeeRepo.delete(employee);
	}

	@Override
	public List<Employee> searchEmployee(String query, Pageable pageable) {
        List<Employee> employees = employeeRepo.searchEmployee(query, pageable).getContent();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("Employee", "query", query);
        }
        return employees;
    }

	@Override
	public Employee getEmployeeByEmail(String email) {
        return employeeRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "email", email));
    }
	
	
	@Override
	public List<Employee> allEmployee(){
		return employeeRepo.findAll();
	}

}
