package com.easyrent.rentcarapp.repository;


import com.easyrent.rentcarapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findById(Long id);
    AppUser findByLogin(String login);
    List<AppUser> findByPassword(String password);

}

