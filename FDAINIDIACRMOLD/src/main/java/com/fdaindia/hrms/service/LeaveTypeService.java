package com.fdaindia.hrms.service;

import com.fdaindia.hrms.entity.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    List<LeaveType> getAllLeaveTypes();
    LeaveType getLeaveTypeById(Long id);
    LeaveType createLeaveType(LeaveType leaveType);
    LeaveType updateLeaveType(Long id, LeaveType leaveTypeDetails);
    void deleteLeaveType(Long id);
}
