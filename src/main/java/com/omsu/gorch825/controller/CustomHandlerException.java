package com.omsu.gorch825.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        return ApiResponse.error(ex.getStatus(), ex.getMessage(), ex.getStackTrace());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .distinct()
                .collect(Collectors.joining("; "));

        return ApiResponse.error(HttpStatus.BAD_REQUEST, message, ex.getStackTrace());
    }
}
