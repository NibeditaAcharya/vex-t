package com.org.vex.t.Service;

import com.org.vex.t.Entity.User;
import com.org.vex.t.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;


    @Autowired
    private UserEmailService emailService;
    UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }



    public String sendotp(String email)
    {
       String otp = emailService.sendMail(email);
       return null;
    }

    public User login(String email)
    {
        Optional<User> user=userRepository.findByEmail(email);

        if(user.isPresent() && user.get().isVerified())
        {
           return user.get();
        }
        throw new EntityNotFoundException("user not Found");
    }



}
