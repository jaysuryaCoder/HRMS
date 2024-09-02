package com.fdaindia.hrms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "under")
	private String under;

	@Column(name = "date_of_joining")
	private String dateOfJoining;

	@Column(name = "employee_number")
	private String employeeNumber;

	@Column(name = "`function`") // Escaping reserved keyword
	private String function;

	@Column(name = "location")
	private String location;

	@Column(name = "somedate")
	private String somedate;

	@Column(name = "date_ofbirth")
	private Date dob;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "branch")
	private String branch;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "pancar_number")
	private String pancardNumber;

	@Column(name = "total_salary")
	private Long totalSalary;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", insertable = true, updatable = false)
	private Department department;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designation_id", insertable = true, updatable = false)
	private Designation designation;
}