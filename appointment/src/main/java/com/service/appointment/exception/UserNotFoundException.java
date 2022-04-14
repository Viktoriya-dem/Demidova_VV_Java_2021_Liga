package com.service.appointment.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("This user not found!");
    }
}
