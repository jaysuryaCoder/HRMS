//package com.fdaindia.hrms.controller;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.fdaindia.hrms.entity.FdaEmployee;
//import com.fdaindia.hrms.response.UserRequest;
//import com.fdaindia.hrms.response.UserResponse;
//import com.fdaindia.hrms.service.impl.FdaEmployeeServiceImpl;
//import com.fdaindia.hrms.services.EmailService;
//import com.fdaindia.hrms.services.FdaEmployeeService;
//import com.fdaindia.hrms.tokenconfig.JwtTokenUtil;
//
//
//
//
//@RestController
//@RequestMapping("/Hrms/emp")
//public class FdaEmployeeController {
//	
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    @Autowired
//    private EmailService emailService;
//    @Autowired
//    private FdaEmployeeService fdaEmployeeService;
//    @Autowired
//    private FdaEmployeeServiceImpl employeeService;
//    @GetMapping("/test")
//    public String user() {
//        System.out.println("Employee hit");
//        return "Employee hit";
//    }
//    
//    @CrossOrigin()
//    @PostMapping("/registration")
//    public UserResponse registerEmployee(@RequestBody FdaEmployee employee) {
//        return fdaEmployeeService.registerEmployee(employee);
//    }
//    @PostMapping("/forgot-password")
//    public String forgotPassword(@RequestParam String email) {
//        return employeeService.generateOtp(email);
//    }
//
//    @PostMapping("/reset-password")
//    public String resetPassword(@RequestParam String email,
//                                @RequestParam String otp,
//                                @RequestParam String newPassword,
//                                @RequestParam String confirmPassword) {
//        return employeeService.verifyOtpAndResetPassword(email, otp, newPassword, confirmPassword);
//    }
//  
//    @PostMapping("/login")
//    public UserResponse loginEmployee(@RequestParam String username, @RequestParam String password) {
//        UserResponse response = fdaEmployeeService.authenticate(username, password);
//        if (response.isStatus()) {
//            FdaEmployee employee = new FdaEmployee();
//            employee.setUsername(username);
//            employee.setRole(response.getRole());
//
//            String sessionId = UUID.randomUUID().toString();
//            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
//            String token = jwtTokenUtil.generateTokenWithSessionId(employee, sessionId, sessionExpiry);
//            
//            response.setToken(token);
//            response.setSessionId(sessionId);
//            response.setSessionExpiry(sessionExpiry);
//            response.setMessage("Login Successful");
//        } else {
//            response.setMessage("Invalid username or password");
//        }
//        return response;
//    }
//
//    @CrossOrigin
//    @PostMapping("/hrmslogin")
//    public UserResponse hrmsUser(@RequestBody UserRequest request) {
//        UserResponse response = new UserResponse();
//        System.out.println(request.getUsername() + " " + request.getPassword());
//        if (request.getUsername().equals("ADMIN") && request.getPassword().equals("Fdaindia@2024")) {
//            response.setStatus(true);
//            String role = "ADMIN"; // Admin role
//            String sessionId = UUID.randomUUID().toString();
//            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
//            FdaEmployee employee = new FdaEmployee(); // Initialize the object properly
//            employee.setUsername(request.getUsername());
//            employee.setRole(role); // Set the role
//            String token = jwtTokenUtil.generateTokenWithSessionId(employee, sessionId, sessionExpiry);
//            response.setToken(token);
//            response.setSessionId(sessionId);
//            response.setSessionExpiry(sessionExpiry);
//            response.setRole(role); // Set the role
//            response.setMessage("HRMS Login Successful");
//        } else {
//            response.setStatus(false);
//            response.setMessage("Failed");
//        }
//        return response;
//    }
////
////    @PostMapping("/login")
////    public UserResponse loginEmployee(@RequestParam String username, @RequestParam String password) {
////        return employeeService.authenticate(username, password);
////    }
////    @CrossOrigin()
////    @PostMapping("/hrmslogin")
////    public UserResponse hrmsUser(@RequestBody UserRequest request) {
////        UserResponse response = new UserResponse();
////        System.out.println(request.getUsername() + " " + request.getPassword());
////        if (request.getUsername().equals("ADMIN") && request.getPassword().equals("Fdaindia@2024")) {
////            response.setStatus(true);
////            String sessionId = UUID.randomUUID().toString();
////            Date sessionExpiry = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY * 1000);
////
//////            FDAIndiaKendra kendra = new FDAIndiaKendra(); // Initialize the object properly
//////            kendra.setUsername(request.getUsername());
////            FdaEmployee employee = new FdaEmployee(); // Initialize the object properly
////            employee.setUsername(request.getUsername());
////
////            String token = jwtTokenUtil.generateTokenWithSessionId(employee, sessionId, sessionExpiry);
////            //String token = jwtTokenUtil.generateTokenWithSessionId(kendra, sessionId, sessionExpiry);
////            response.setToken(token);
////            response.setSessionId(sessionId);
////            response.setSessionExpiry(sessionExpiry);
////            response.setMessage("HRMS Login Successful");
////        } else {
////            response.setStatus(false);
////            response.setMessage("Failed");
////        }
////        return response;
////    }
//
//
//
//}
