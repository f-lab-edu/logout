package com.example.hotelproject.util.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ErrorResponse handleException(CustomException ex){
        ErrorResponse response = new ErrorResponse(ErrorCode.DATA_NOT_FOUND);
        return response;
    }
}
