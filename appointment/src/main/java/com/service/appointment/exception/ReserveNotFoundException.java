package com.service.appointment.exception;

public class ReserveNotFoundException extends RuntimeException{
    public ReserveNotFoundException() {
        super("This reserve not found!");
    }
}
