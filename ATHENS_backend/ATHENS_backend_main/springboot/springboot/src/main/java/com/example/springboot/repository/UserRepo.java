package com.example.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.User;

public interface UserRepo extends JpaRepository <User,Integer> {

    Optional<User> findByEmail(String email);
    
}