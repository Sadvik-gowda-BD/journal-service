package com.example.journalservice.exception;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){
        super(message);
    }
}
