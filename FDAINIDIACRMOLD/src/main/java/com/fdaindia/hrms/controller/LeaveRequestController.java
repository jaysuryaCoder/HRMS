package com.fdaindia.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.entity.LeaveRequest;
import com.fdaindia.hrms.services.EmployeeService;
import com.fdaindia.hrms.service.EmailSenderService;
import com.fdaindia.hrms.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leave_request")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;
    
    @Autowired
    private EmailSenderService emailService;
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequestById(id);
    }

    @PostMapping("/createLeave")
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @PutMapping("/{id}")
    public LeaveRequest updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequest leaveRequestDetails) {
       Employee employee=employeeService.getEmployeeById(leaveRequestDetails.getEmployee().getId());
       String email=employee.getEmail();
       String name=employee.getUsername();
       System.out.println(email+" HHHHHHHHHHHHHHHHHH");
       long days=leaveRequestService.calculateLeaveDays(id);
       String message="your "+days+" of leave request approved successfully "+name+" Take Proper rest and be ready for next movement ";
       String subject="Leave Approval From Admin side";
       emailService.sendEmail(email, subject, message);
    	
    	return leaveRequestService.updateLeaveRequest(id, leaveRequestDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
    }
}
