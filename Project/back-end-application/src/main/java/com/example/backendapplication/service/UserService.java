package com.example.backendapplication.service;

import com.example.backendapplication.exception.UserNotFoundException;
import com.example.backendapplication.model.User;
import com.example.backendapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User newUser){
        return repository.save(newUser);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getById(Long id){
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    public User updateUser(User updatedUser, Long id){
        return repository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setAddress(updatedUser.getAddress());
            user.setEmail(updatedUser.getEmail());
            repository.save(user);
            return user;
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    public String deleteUser(Long id){
        repository.deleteById(id);
        return "user with user id "+id+" has been removed";
    }

}
