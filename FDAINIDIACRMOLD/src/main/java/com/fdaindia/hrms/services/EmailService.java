package com.fdaindia.hrms.services;


public interface EmailService {
    void sendEmail(String toEmail, String subject, String body);
}
