package com.yscp.randomtravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // This handles your CustomAuthenticationException and returns a proper response
    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomAuthenticationException(CustomAuthenticationException ex) {
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    // This handles all other uncaught exceptions and returns an INTERNAL_SERVER_ERROR (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponseDto("An error occurred: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
