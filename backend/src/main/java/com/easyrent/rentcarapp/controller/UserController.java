package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.User;
import com.easyrent.rentcarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
   public List<User> getAllCars() { return userService.findAllUsers(); }

    @RequestMapping(value = "/users/id/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/users/login/{login}", method = RequestMethod.GET)
    public List<User> getUsersByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value = "/users/pssword/{password}", method = RequestMethod.GET)
    public List<User> getUsersByPassword(@PathVariable String password) {
        return userService.findByPassword(password);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insertNewUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestBody Long id) {
        userService.deleteUserById(id);
    }

}



