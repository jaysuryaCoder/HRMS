package com.fdaindia.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdaindia.hrms.entity.DeletedEmployee;

public interface DeletedEmployeeRepo extends JpaRepository<DeletedEmployee, Long> {

}
