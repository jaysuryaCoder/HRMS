//package com.fdaindia.hrms.service.impl;
//
//import java.util.Map;
//import java.util.Random;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.stereotype.Service;
//
//import com.fdaindia.hrms.service.OTPService;
//
//@Service
//public class OTPServiceImpl implements OTPService{
//
//    private Map<String, Integer> otpStorage = new ConcurrentHashMap<>();
//
//    public int generateOTP(String email) {
//        Random random = new Random();
//        int otp = 1000 + random.nextInt(9000);
//        otpStorage.put(email, otp);
//        return otp;
//    }
//
//    public boolean verifyOTP(String email, int otp) {
//        if (otpStorage.containsKey(email) && otpStorage.get(email) == otp) {
//            otpStorage.remove(email);
//            return true;
//        }
//        return false;
//    }
//}
//
