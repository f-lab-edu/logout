package com.example.hotelproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler { // 이건 왠만하면 컨트롤러랑 같은 패키지에 위치하는게 좋을 것 같아요 ~

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleNotFoundException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
