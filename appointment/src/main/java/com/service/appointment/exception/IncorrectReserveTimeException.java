package com.service.appointment.exception;

public class IncorrectReserveTimeException extends RuntimeException{

    public IncorrectReserveTimeException() {
        super("Incorrect input! Input date later then this time, format 'yyyy-MM-dd HH:mm', mm must be 00");
    }
}
