package com.omsu.gorch825.models.Primitives;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiResponse<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HttpStatus errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StackTraceElement[] details;

    public ApiResponse(boolean success, T data, HttpStatus errorCode, String errorMessage,
            StackTraceElement[] details) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null, null, null);
    }

    public static <T> ApiResponse<T> error(HttpStatus errorCode, String errorMessage, StackTraceElement[] details) {
        return new ApiResponse<>(false, null, errorCode, errorMessage, details);
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public StackTraceElement[] getDetails() {
        return details;
    }
}
