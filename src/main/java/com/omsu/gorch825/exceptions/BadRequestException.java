package com.omsu.gorch825.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    private final HttpStatus status;

    public BadRequestException(HttpStatus badRequest, String message) {
        super(message);
        this.status = badRequest;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
