package com.example.hotelproject.util.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private String code;
    private HttpStatus status;

    public ErrorResponse(ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }

    public static ErrorResponse of(ErrorCode code) {
        return new ErrorResponse(code);
    }
}
