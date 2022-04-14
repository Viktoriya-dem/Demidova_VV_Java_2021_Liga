package com.service.appointment.exception;

public class NoReserveException extends RuntimeException{
    public NoReserveException() {
        super("No reserves in base!");
    }
}
