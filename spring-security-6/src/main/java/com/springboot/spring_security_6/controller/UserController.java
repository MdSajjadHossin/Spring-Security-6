package com.springboot.spring_security_6.controller;

import com.springboot.spring_security_6.entity.User;
import com.springboot.spring_security_6.repository.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User user1 = userRepo.findByUserName(user.getUserName());
        if(!Objects.isNull(user1)){
            return "login Successful";
        }
        return "User not exists login failed";
    }

}
