package com.fdaindia.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdaindia.hrms.entity.LeaveType;
import com.fdaindia.hrms.response.FinalResponse;
import com.fdaindia.hrms.service.LeaveTypeService;

@RestController
@RequestMapping("/api/leave_type")
public class LeaveTypeController {

	@Autowired
	private LeaveTypeService leaveTypeService;

	@CrossOrigin()
	@GetMapping
	public FinalResponse getAllLeaveTypes() {
		FinalResponse response = new FinalResponse();
		List<LeaveType> leaves = leaveTypeService.getAllLeaveTypes();
		if (leaves != null) {
			response.setStatus(true);
			response.setObject(leaves);
			response.setMessage("List of All LeaveType fetched successfully");
		} else {
			response.setStatus(false);
			response.setObject(null);
			response.setMessage("Something wrong!!");
		}
		return response;
	}

	@CrossOrigin()
	@GetMapping("/{id}")
	public FinalResponse getLeaveTypeById(@PathVariable Long id) {
		FinalResponse response = new FinalResponse();
		LeaveType leave = leaveTypeService.getLeaveTypeById(id);
		if (leave != null) {
			response.setStatus(true);
			response.setObject(leave);
			response.setMessage("LeaveType of this Particular id exist");
		} else {
			response.setStatus(false);
			response.setObject(null);
			response.setMessage("LeaveType of this Perticular id does not exist ");
		}
		return response;
	}

	@CrossOrigin()
	@PostMapping("/create")
	public FinalResponse createLeaveType(@RequestBody LeaveType leaveType) {
		FinalResponse response = new FinalResponse();
		LeaveType leave = leaveTypeService.createLeaveType(leaveType);
		response.setStatus(true);
		response.setObject(leave);
		response.setMessage("LeaveTpye Created Successfully");
		return response;

	}

	@CrossOrigin()
	@PutMapping("/{id}")
	public FinalResponse updateLeaveType(@PathVariable Long id, @RequestBody LeaveType leaveType) {
		FinalResponse response = new FinalResponse();
		LeaveType leave = leaveTypeService.updateLeaveType(id, leaveType);
		if (leave != null) {
			response.setStatus(true);
			response.setObject(leave);
			response.setMessage("LeaveType updated Successfully");
		} else {
			response.setStatus(false);
			response.setObject(null);
			response.setMessage("LeaveType Not UpdatedSuccessfully");
		}

		return response;
	}

	@CrossOrigin()
	@DeleteMapping("/{id}")
	public String deleteLeaveType(@PathVariable Long id) {

		leaveTypeService.deleteLeaveType(id);
		return "LeaveType deleted successfully   " + id;
	}

}
