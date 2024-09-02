package com.fdaindia.hrms.service;

import com.fdaindia.hrms.entity.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    List<LeaveRequest> getAllLeaveRequests();
    LeaveRequest getLeaveRequestById(Long id);
    LeaveRequest createLeaveRequest(LeaveRequest leaveRequest);
    LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequestDetails); // Single update method
    void deleteLeaveRequest(Long id);
    
    long calculateLeaveDays(Long leaveRequestId);
}
