package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.AppUser;
import com.easyrent.rentcarapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
    }
}



