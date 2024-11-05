package com.org.vex.t;


import com.org.vex.t.Entity.User;
import com.org.vex.t.Service.OtpService;
import com.org.vex.t.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
@RestController
public class Controller {


    @Autowired
     private UserService userService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/Send_email")
    public String SendMail(@RequestParam String email)
    {
        return  userService.sendotp(email);
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isVerified = otpService.verifyOtp(email, otp);
        if (isVerified) {
            return "OTP verified successfully!";
        } else {
            return "Invalid OTP.";
        }
    }

    @PostMapping("/login")
    public User login(@RequestParam String email)
    {
        return userService.login(email);
    }


}
