package com.easyrent.rentcarapp.service;

import com.easyrent.rentcarapp.entity.AppUser;


import java.util.List;

public interface UserService
{
    List<AppUser> findAllUsers();

    AppUser findUserById(Long id);

    AppUser findByLogin(String login);

    List<AppUser> findByPassword(String password);

    void saveUser(AppUser appUser);

    void updateUser(AppUser appUser);

    void deleteUserById(Long id);
}


