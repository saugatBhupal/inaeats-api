package com.inaing.inaeats.exception.exceptions;

public class FileUploadException extends RuntimeException {
    private final int status;

    public FileUploadException(String message) {
        super(message);
        this.status = 500;
    }

    public int getStatus() {
        return this.status;
    }
}
