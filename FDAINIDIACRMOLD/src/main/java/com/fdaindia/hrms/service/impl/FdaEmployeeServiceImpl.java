//package com.fdaindia.hrms.service.impl;
//
//import com.fdaindia.hrms.entity.FdaEmployee;
//import com.fdaindia.hrms.repository.FdaEmployeeRepository;
//import com.fdaindia.hrms.response.UserResponse;
//import com.fdaindia.hrms.services.EmailService;
//import com.fdaindia.hrms.services.FdaEmployeeService;
//import com.fdaindia.hrms.tokenconfig.JwtTokenUtil;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.Optional;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class FdaEmployeeServiceImpl implements FdaEmployeeService {
//@Autowired
//private EmailService emailService;
//    @Autowired
//    private FdaEmployeeRepository employeeRepository;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
////    @Override
////    public UserResponse registerEmployee(FdaEmployee employee) {
////        FdaEmployee savedEmployee = employeeRepository.save(employee);
////
////        String subject = "Welcome to FDA India HRMS";
////        String body = "Dear " + savedEmployee.getUsername() + ",\n\n" +
////                "Your account has been created.\n" +
////                "Username: " + savedEmployee.getUsername() + "\n" +
////                "Password: " + savedEmployee.getPassword() + "\n\n" +
////                "Please change your password after your first login.";
////
////        emailService.sendEmail(savedEmployee.getEmail(), subject, body);
////
////        UserResponse response = new UserResponse();
////        response.setStatus(true);
////        response.setMessage("Employee registered successfully and email sent");
////
////        return response;
////    }
//    @Override
//    public UserResponse registerEmployee(FdaEmployee employee) {
//        UserResponse response = new UserResponse();
//        
//        // Check if the username is already taken
//        if (employeeRepository.findByUsername(employee.getUsername()).isPresent()) {
//            response.setStatus(false);
//            response.setMessage("Username already exists");
//            return response;
//        }
//        
//        // Check if the email is already registered
//        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
//            response.setStatus(false);
//            response.setMessage("Email already exists");
//            return response;
//        }
//        
//        FdaEmployee savedEmployee = employeeRepository.save(employee);
//        
//        String subject = "Welcome to FDA India HRMS";
//        String body = "Dear " + savedEmployee.getUsername() + ",\n\n" +
//                "Your account has been created.\n" +
//                "Username: " + savedEmployee.getUsername() + "\n" +
//                "Password: " + savedEmployee.getPassword() + "\n\n" +
//                "Please change your password after your first login.";
//        
//        emailService.sendEmail(savedEmployee.getEmail(), subject, body);
//        
//        response.setStatus(true);
//        response.setMessage("Employee registered successfully and email sent");
//        
//        return response;
//    }
//    @Override
//    public Optional<FdaEmployee> getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }
//
//    @Override
//    public UserResponse authenticate(String username, String password) {
//        Optional<FdaEmployee> employeeOpt = employeeRepository.findByUsername(username);
//        if (employeeOpt.isPresent()) {
//            FdaEmployee employee = employeeOpt.get();
//            if (employee.getPassword().equals(password)) {
//                String sessionId = "SessionID_" + username; // Generate session ID as needed
//                Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
//                String token = jwtTokenUtil.generateTokenWithSessionId(employee, sessionId, sessionExpiry);
//
//                UserResponse response = new UserResponse();
//                response.setToken(token);
//                response.setSessionExpiry(sessionExpiry);
//                response.setSessionId(sessionId);
//                response.setRole(employee.getRole()); // Set the role
//                response.setStatus(true);
//                response.setMessage("Login successful");
//                return response;
//            }
//        }
//        UserResponse response = new UserResponse();
//        response.setStatus(false);
//        response.setMessage("Invalid username or password");
//        return response;
//    }
//    @Override
//    public String generateOtp(String email) {
//        Optional<FdaEmployee> employeeOpt = employeeRepository.findByEmail(email);
//        if (employeeOpt.isPresent()) {
//            FdaEmployee employee = employeeOpt.get();
//            String otp = String.format("%06d", new Random().nextInt(999999));
//            employee.setOtp(otp);
//            employee.setOtpExpiry(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)));
//            employeeRepository.save(employee);
//
//            String subject = "Your OTP for Password Reset";
//            String body = "Your OTP for password reset is: " + otp;
//            emailService.sendEmail(employee.getEmail(), subject, body);
//
//            return "OTP sent to your email.";
//        } else {
//            return "Email not found.";
//        }
//    }
//
//    @Override
//    public String verifyOtpAndResetPassword(String email, String otp, String newPassword, String confirmPassword) {
//        if (!newPassword.equals(confirmPassword)) {
//            return "Passwords do not match.";
//        }
//
//        Optional<FdaEmployee> employeeOpt = employeeRepository.findByEmail(email);
//        if (employeeOpt.isPresent()) {
//            FdaEmployee employee = employeeOpt.get();
//            if (employee.getOtp().equals(otp) && employee.getOtpExpiry().after(new Date())) {
//                employee.setPassword(newPassword);
//                employee.setOtp(null);
//                employee.setOtpExpiry(null);
//                employeeRepository.save(employee);
//                return "Password reset successfully.";
//            } else {
//                return "Invalid or expired OTP.";
//            }
//        } else {
//            return "Email not found.";
//        }
//    }
//
//}
