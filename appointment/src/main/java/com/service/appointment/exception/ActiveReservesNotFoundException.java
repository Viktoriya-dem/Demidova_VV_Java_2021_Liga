package com.service.appointment.exception;

public class ActiveReservesNotFoundException extends RuntimeException {
    public ActiveReservesNotFoundException() {
        super("No active reserves for you!");
    }
}
