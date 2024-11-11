package com.org.vex.t.Service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class UserEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    OtpService otpService;

    public String sendMail(String email) {
        System.out.println(email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Otp for acccount verification:");
        String otp =otpService.generateOtp() ;
            otpService.storeOtp(email,otp);
        message.setText("Your OTP:"+otp);
        message.setFrom("nibeditaacharya82@gmail.com");
       mailSender.send(message);

  return otp;
    }



    public String send()
    {
        return null;
    }


}
