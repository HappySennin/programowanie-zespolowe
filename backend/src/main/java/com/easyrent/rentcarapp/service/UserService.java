package com.easyrent.rentcarapp.service;

import com.easyrent.rentcarapp.entity.User;


import java.util.List;

public interface UserService
{
    List<User> findAllUsers();

    User findUserById(Long id);

    List<User> findByLogin(String login);

    List<User> findByPassword(String password);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}


