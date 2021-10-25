package com.service.appointment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value={BusyReserveTimeException.class, IncorrectReserveTimeException.class,NoReserveException.class})
    public ResponseEntity<String> handleException(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value={ActiveReservesNotFoundException.class, ReserveNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<String> handleException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
