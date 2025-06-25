package com.inaing.inaeats.exception.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private final int status;

    public ResourceNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return this.status;
    }
}
