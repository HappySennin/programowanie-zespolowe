package com.easyrent.rentcarapp.repository;


import com.easyrent.rentcarapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    List<User> findByLogin(String login);
    List<User> findByPassword(String password);

}

