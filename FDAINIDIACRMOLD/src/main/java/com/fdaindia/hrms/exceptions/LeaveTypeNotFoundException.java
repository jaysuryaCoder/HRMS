package com.fdaindia.hrms.exceptions;

public class LeaveTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	 public LeaveTypeNotFoundException(String message) {
	        super(message);
	    }
}
