package com.fdaindia.hrms.request;

import lombok.Data;

@Data
public class OTPRequest {
	private String toEmail;
	private int otp;
}