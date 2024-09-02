package com.fdaindia.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdaindia.hrms.entity.FdaEmployee;

@Repository
public interface FdaEmployeeRepository extends JpaRepository<FdaEmployee, Long> {
    Optional<FdaEmployee> findByUsername(String username);
   
    Optional<FdaEmployee> findByEmail(String email);
}