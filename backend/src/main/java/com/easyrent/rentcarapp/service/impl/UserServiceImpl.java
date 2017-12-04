package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.User;
import com.easyrent.rentcarapp.repository.UserRepository;
import com.easyrent.rentcarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id)
    {
        return userRepository.findById(id);
    }

    @Override
    public User findByLogin(String login)
    {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> findByPassword(String password)
    {
        return userRepository.findByPassword(password);
    }

    @Override
    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user)
    {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id)
    {
        userRepository.delete(id);
    }
}

