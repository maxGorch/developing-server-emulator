package com.omsu.gorch825.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.omsu.gorch825.exceptions.NotFoundException;

@Service
public class ExceptionsService {
    public void methodException() throws NotFoundException {
        throw new NotFoundException(HttpStatus.NOT_FOUND, "Object not found!");
    }
}
