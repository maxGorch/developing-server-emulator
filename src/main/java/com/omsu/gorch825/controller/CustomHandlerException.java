package com.omsu.gorch825.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.omsu.gorch825.exceptions.NotFoundException;
import com.omsu.gorch825.models.Primitives.ApiResponse;

@RestControllerAdvice
public class CustomHandlerException {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> handleNotFoundException(NotFoundException ex) {
        return new ApiResponse<>(false, HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }
}
