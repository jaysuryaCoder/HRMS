package com.fdaindia.hrms.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "deleted_employee")
public class DeletedEmployee {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeletedEmployee(Long id, Long originalId, LocalDateTime deletionTime, String username, String under,
			String dateOfJoining, String employeeNumber, String function, String location, String somedate, Date dob,
			String bloodGroup, String fatherName, String motherName, String address, String contactNumber, String email,
			String bankName, String branch, String bankAccountNumber, String pancardNumber, Long totalSalary) {
		super();
		this.id = id;
		this.originalId = originalId;
		this.deletionTime = deletionTime;
		this.username = username;
		this.under = under;
		this.dateOfJoining = dateOfJoining;
		this.employeeNumber = employeeNumber;
		this.function = function;
		this.location = location;
		this.somedate = somedate;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.bankName = bankName;
		this.branch = branch;
		this.bankAccountNumber = bankAccountNumber;
		this.pancardNumber = pancardNumber;
		this.totalSalary = totalSalary;
	}

	public Long getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Long originalId) {
		this.originalId = originalId;
	}

	public LocalDateTime getDeletionTime() {
		return deletionTime;
	}

	public void setDeletionTime(LocalDateTime deletionTime) {
		this.deletionTime = deletionTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUnder() {
		return under;
	}

	public void setUnder(String under) {
		this.under = under;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSomedate() {
		return somedate;
	}

	public void setSomedate(String somedate) {
		this.somedate = somedate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public Long getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Long totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;
	
	@Column(name = "original_id")
	private Long originalId;
	
	@Column(name = "deletion_time")
	private LocalDateTime deletionTime;
	
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
}
