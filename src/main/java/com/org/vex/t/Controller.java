package com.org.vex.t;


import com.org.vex.t.Entity.User;
import com.org.vex.t.Service.OtpService;
import com.org.vex.t.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> SendMail(@RequestParam String email)
    {
        System.out.println(email);
        return new ResponseEntity<>( userService.sendotp(email),HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        System.out.println("VV"+email);
        boolean isVerified = otpService.verifyOtp(email, otp);
        if (isVerified) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email)
    {
        return new  ResponseEntity<>(userService.login(email), HttpStatus.OK);
    }





}
