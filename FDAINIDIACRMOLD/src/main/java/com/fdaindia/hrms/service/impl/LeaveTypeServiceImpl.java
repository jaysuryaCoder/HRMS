package com.fdaindia.hrms.service.impl;

import com.fdaindia.hrms.entity.LeaveType;
import com.fdaindia.hrms.exceptions.LeaveTypeNotFoundException;
import com.fdaindia.hrms.repository.LeaveTypeRepository;
import com.fdaindia.hrms.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    @Override
    public LeaveType getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id)
                .orElseThrow(() -> new LeaveTypeNotFoundException("Leave type not found with id " + id));
    }

    @Override
    public LeaveType createLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    @Override
    public LeaveType updateLeaveType(Long id, LeaveType leaveTypeDetails) {
        LeaveType leaveType = leaveTypeRepository.findById(id)
                .orElseThrow(() -> new LeaveTypeNotFoundException("Leave type not found with id " + id));

        leaveType.setLeaveName(leaveTypeDetails.getLeaveName());
        leaveType.setLeaveType(leaveTypeDetails.getLeaveType());
        leaveType.setCarryForward(leaveTypeDetails.isCarryForward());
        leaveType.setMaxDays(leaveTypeDetails.getMaxDays());
        leaveType.setDescription(leaveTypeDetails.getDescription());
        
        return leaveTypeRepository.save(leaveType);
    }

    @Override
    public void deleteLeaveType(Long id) {
        LeaveType leaveType = leaveTypeRepository.findById(id)
                .orElseThrow(() -> new LeaveTypeNotFoundException("Leave type not found with id " + id));
        leaveTypeRepository.delete(leaveType);
    }
}
