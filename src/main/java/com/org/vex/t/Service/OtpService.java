package com.org.vex.t.Service;

import com.org.vex.t.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.org.vex.t.Entity.User;
@Service
public class OtpService {


    @Autowired
    UserRepository userRepository;
    private Map<String, String> otpStorage = new HashMap<>();

    public String generateOtp() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);

    }

    public void storeOtp(String email, String otp) {
        otpStorage.put(email, otp);

    }

    public boolean verifyOtp(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            User user = new User();
            user.setEmail(email);
            user.setVerified(true);
            userRepository.save(user);
            return true;
        }

        return false;
    }





}