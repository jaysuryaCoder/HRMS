package com.fdaindia.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdaindia.hrms.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
