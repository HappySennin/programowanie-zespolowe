package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.AppUser;
import com.easyrent.rentcarapp.repository.UserRepository;
import com.easyrent.rentcarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/users/sign-up", method = RequestMethod.POST)
    public boolean signUp(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return userService.saveUser(appUser);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "users/getid/{username}", method = RequestMethod.GET)
    public Long getUserId(@PathVariable String username) {
        return userService.findByLogin(username).getId();
    }
}



