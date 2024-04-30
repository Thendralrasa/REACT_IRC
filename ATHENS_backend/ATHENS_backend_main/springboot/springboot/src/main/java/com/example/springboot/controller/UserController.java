package com.example.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
public class UserController
{
    

@Autowired
private UserService userService;

@PostMapping("/createUser")

public ResponseEntity<User> createUser(@NonNull @RequestBody User user) {

User createdUser = userService.createnewuser(user);

return new ResponseEntity<>(createdUser, HttpStatus.OK);

}

@GetMapping("/readUser/{email}")

//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<User> getUserByEmail(@PathVariable String email)
{

Optional<User> user = userService.getModelByEmail(email);

return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

@GetMapping("/readUsers")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<List<User>> getAllUsers()
{

List<User> users = userService.getAllusers();

return new ResponseEntity<>(users, HttpStatus.OK);

}

@PutMapping("/updateUser/{id}")

// @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<User> updateUser(@NonNull @PathVariable Integer id,@RequestBody User updateRequest)
{

User updated = userService.updateUser(id, updateRequest);

return new ResponseEntity<>(updated, HttpStatus.OK);

}

@DeleteMapping("/deleteUser/{userId}")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}
