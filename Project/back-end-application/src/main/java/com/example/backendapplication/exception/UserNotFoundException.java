package com.example.backendapplication.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not found the user with user id: "+id);
    }
}
