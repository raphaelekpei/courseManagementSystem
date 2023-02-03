package com.raphael.coursemanagementsystems.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserManagementException.class)
    public ResponseEntity<Object> UserManagementExceptionHandler(UserManagementException userManagementException){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .isSuccessful(false)
                .message(userManagementException.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
