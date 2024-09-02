package com.fdaindia.hrms.exceptions;

public class LeaveRequestNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LeaveRequestNotFoundException(String message) {
        super(message);
    }
}
