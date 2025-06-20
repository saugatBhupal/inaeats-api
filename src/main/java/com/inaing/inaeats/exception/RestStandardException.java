package com.inaing.inaeats.exception;

public class RestStandardException extends RuntimeException {
    private final int status;

    public RestStandardException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
