package com.fdaindia.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.service.EmailSenderService;
import com.fdaindia.hrms.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailSenderService service;

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping("/send")
	public String senEmail() {
		List<Employee> emp = employeeService.allEmployee();
		String subject="Birthday's Wishes";
		if(emp != null) {
			for(Employee e:emp) {
				String body=generateHtmlForBirthday(e);
				service.sendEmail(e.getEmail(), subject, body);
			}
		}

		return "Email send to successfully ";
	}
	
	private String generateHtmlForBirthday(Employee emp) {
	    String template = "<html><body>"
	                    + "<p>Dear %s,</p>"
	                    + "<p>Wishing you a day filled with happiness and a year filled with joy. Happy birthday!</p>"
	                    + "<p>May your birthday be the start of a year filled with good luck, good health, and much happiness.</p>"
	                    + "<p>Thank you for being a part of our team. We appreciate your dedication and hard work.</p>"
	                    + "<p>Enjoy your special day!</p>"
	                    + "<p>Best regards,<br>FDA India</p>"
	                    + "<img src='cid:logoImage' alt='FDA India Kendra' style='width:25%%; height:auto;' /><br>"
	                    + "<b>Website: www.fdaindia.org</b><br>"
	                    + "<b>Telephone:+91-8527407839</b>"
	                    + "</body></html>";
	    return String.format(template, emp.getEmail());
	}


}