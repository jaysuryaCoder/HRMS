package com.fdaindia.hrms.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdaindia.hrms.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :query, '%'))")
	Page<Employee> searchEmployee(@Param("query") String query, Pageable pageable);

	Optional<Employee> findByEmail(String email);
}
