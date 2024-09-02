package com.fdaindia.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdaindia.hrms.entity.Designation;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Long> {
	@Query("SELECT d FROM Designation d WHERE d.department.id = :departmentId")
	List<Designation> findByDepartmentId(@Param("departmentId") Long departmentId);

}
