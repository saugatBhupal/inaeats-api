package com.inaing.inaeats.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inaing.inaeats.dto.error.ErrorMessageDto;
import com.inaing.inaeats.exception.exceptions.FileUploadException;
import com.inaing.inaeats.exception.exceptions.RestStandardException;
import com.inaing.inaeats.response.RestStandardResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestStandardException.class)
    public ResponseEntity<RestStandardResponse<ErrorMessageDto>> restException(RestStandardException exception) {
        RestStandardResponse<ErrorMessageDto> response = new RestStandardResponse<>(exception.getStatus(),
                new ErrorMessageDto(exception.getMessage()));
        return ResponseEntity.status(exception.getStatus()).body(response);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<RestStandardResponse<ErrorMessageDto>> usernameNotFoundException(
            UsernameNotFoundException exception) {
        RestStandardResponse<ErrorMessageDto> response = new RestStandardResponse<>(404,
                new ErrorMessageDto(exception.getMessage()));
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<RestStandardResponse<ErrorMessageDto>> fileUploadException(FileUploadException exception) {
        RestStandardResponse<ErrorMessageDto> response = new RestStandardResponse<ErrorMessageDto>(500,
                new ErrorMessageDto(exception.getMessage()));
        return ResponseEntity.status(500).body(response);
    }

}
