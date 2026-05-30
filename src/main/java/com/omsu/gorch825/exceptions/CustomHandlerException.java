package com.omsu.gorch825.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.omsu.gorch825.models.Primitives.ApiResponse;

@RestControllerAdvice
public class CustomHandlerException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> handleNotFoundException(NotFoundException ex) {
        return ApiResponse.error(ex.getStatus(), ex.getMessage(), ex.getStackTrace());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleBadRequestException(BadRequestException ex) {
        return ApiResponse.error(ex.getStatus(), ex.getMessage(), ex.getStackTrace());
    }
}