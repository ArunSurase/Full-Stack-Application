package com.example.backendapplication.controller;

import com.example.backendapplication.model.User;
import com.example.backendapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getById(id);
//                users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow();
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable Long id){
        return userService.updateUser(updatedUser,id);
//        users.stream().filter(user -> user.getId().equals(id))
//                .findFirst().map(user -> {user.setId(updatedUser.getId());
//                    user.setName(updatedUser.getName());
//                    user.setAddress(updatedUser.getAddress());
//                    user.setEmail(updatedUser.getEmail());
//                    return user;
//                }).orElseThrow();
//        return null;
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
//        users = users.stream().filter(user -> !user.getId().equals(id)).collect(Collectors.toList());
//        return "user with user id "+id+" has been removed";
    }
}
