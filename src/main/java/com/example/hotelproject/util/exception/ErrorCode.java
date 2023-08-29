package com.example.hotelproject.util.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //System
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),

    //custum
    DATA_NOT_FOUND(HttpStatus.NO_CONTENT, "CE0001","데이터가 없습니다.");

    private HttpStatus status;
    private final String code;
    private String message;

    ErrorCode(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }
    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
