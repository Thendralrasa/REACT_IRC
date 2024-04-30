package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepo;

@Service
public class UserService
{
    @Autowired
    private UserRepo ab;
    //create user

    public User createnewuser(@NonNull User user)
    {
        return ab.save(user);
    }
    //getuser

    public List<User> getAllusers()
    {
        return ab.findAll();
    }
    //getuserusingemail
    public Optional<User>getModelByEmail(String email)
    {
        return ab.findByEmail(email);
    }
    //update user
    public User updateUser(@NonNull Integer id,@RequestBody User user)
    {
        return ab.findById(id)
        .map(existingUser->{
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return ab.save(existingUser);
        }).orElseThrow(()->new RuntimeException("User not found with this email: "+id));

    }
    // Remove User
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }
}