package com.inaing.inaeats.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inaing.inaeats.dto.error.ErrorMessageDto;
import com.inaing.inaeats.response.RestStandardResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestStandardException.class)
    public ResponseEntity<RestStandardResponse<ErrorMessageDto>> restException(RestStandardException exception) {
        RestStandardResponse<ErrorMessageDto> response = new RestStandardResponse<>(exception.getStatus(),
                new ErrorMessageDto(exception.getMessage()));
        return ResponseEntity.status(exception.getStatus()).body(response);
    }

}
