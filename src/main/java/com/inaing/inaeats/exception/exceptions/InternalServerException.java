package com.inaing.inaeats.exception.exceptions;

public class InternalServerException extends RuntimeException {
    private final Integer status;

    public InternalServerException(String message) {
        super(message);
        this.status = 500;
    }

    public Integer getStatus() {
        return status;
    }

}
