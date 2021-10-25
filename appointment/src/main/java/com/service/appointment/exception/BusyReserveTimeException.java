package com.service.appointment.exception;

public class BusyReserveTimeException extends RuntimeException{
    public BusyReserveTimeException() {
        super("This time is busy! Choose another time!");
    }
}