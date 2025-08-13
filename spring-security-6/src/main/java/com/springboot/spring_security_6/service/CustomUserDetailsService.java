package com.springboot.spring_security_6.service;


import com.springboot.spring_security_6.entity.User;
import com.springboot.spring_security_6.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    private final User user;

    public CustomUserDetailsService(UserRepo userRepo, User user) {
        this.userRepo = userRepo;
        this.user = user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.springboot.spring_security_6.entity.User user = userRepo.findByUserName(username);
        if(Objects.isNull(user)){
            System.out.println("User not available");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
