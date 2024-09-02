package com.fdaindia.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="leave_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LeaveType {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "leave_type_id")
	    private Long id;

	    @Column(name = "leave_name", nullable = false)
	    private String leaveName;

	    @Column(name = "leave_type", nullable = false)
	    private String leaveType;

	    @Column(name = "carry_forward")
	    private boolean carryForward;

	    @Column(name = "max_days", nullable = true)
	    private int maxDays;

	    @Column(name = "description")
	    private String description;

}
