package com.omsu.gorch825.API.view;

public class ResponseEntity<T> {
    private T data;
    private int status;

    public ResponseEntity(T data, int status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}
