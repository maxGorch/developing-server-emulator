package com.omsu.gorch825.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Exception {

    public NotFoundException(HttpStatus notFound, String message) {

    }

}
