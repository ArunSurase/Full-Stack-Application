package com.example.backendapplication.controller;

import com.example.backendapplication.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    List<User> users = new ArrayList<>();
    @GetMapping("/users")
    public List<User> getAllUser(){
        return users;
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow();
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User newUser){
        users.add(newUser);
        return newUser;
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable Long id){
        users.stream().filter(user -> user.getId().equals(id))
                .findFirst().map(user -> {user.setId(updatedUser.getId());
                    user.setName(updatedUser.getName());
                    user.setAddress(updatedUser.getAddress());
                    user.setEmail(updatedUser.getEmail());
                    return user;
                }).orElseThrow();
        return null;
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        users = users.stream().filter(user -> !user.getId().equals(id)).collect(Collectors.toList());
        return "user with user id "+id+" has been removed";
    }
}
