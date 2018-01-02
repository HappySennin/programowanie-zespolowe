package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.AppUser;
import com.easyrent.rentcarapp.repository.UserRepository;
import com.easyrent.rentcarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findUserById(Long id)
    {
        return userRepository.findById(id);
    }

    @Override
    public AppUser findByLogin(String login)
    {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<AppUser> findByPassword(String password)
    {
        return userRepository.findByPassword(password);
    }

    @Override
    public boolean saveUser(AppUser appUser)
    {
        if(!(findByLogin(appUser.getLogin()) == null)) {
            return false;
        }
        userRepository.save(appUser);
        return true;
    }

    @Override
    public void updateUser(AppUser appUser)
    {
        userRepository.save(appUser);
    }

    @Override
    public void deleteUserById(Long id)
    {
        userRepository.delete(id);
    }
}

