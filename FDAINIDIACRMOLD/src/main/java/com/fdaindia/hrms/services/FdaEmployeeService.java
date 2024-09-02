package com.fdaindia.hrms.services;

import com.fdaindia.hrms.entity.FdaEmployee;
import com.fdaindia.hrms.response.UserResponse;

import java.util.Optional;

public interface FdaEmployeeService {
    UserResponse registerEmployee(FdaEmployee employee);
    Optional<FdaEmployee> getEmployeeById(Long id);
    UserResponse authenticate(String username, String password);
    String generateOtp(String email); // New method for generating OTP
    String verifyOtpAndResetPassword(String email, String otp, String newPassword, String confirmPassword); // New method for verifying OTP and resetting password
}
