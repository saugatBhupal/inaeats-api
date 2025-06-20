package com.inaing.inaeats.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inaing.inaeats.response.RestStandardResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestStandardException.class)
    public ResponseEntity<RestStandardResponse<String>> restException(RestStandardException exception) {
        RestStandardResponse<String> response = new RestStandardResponse<>(exception.getStatus(),
                exception.getMessage());
        return ResponseEntity.status(exception.getStatus()).body(response);
    }

}
