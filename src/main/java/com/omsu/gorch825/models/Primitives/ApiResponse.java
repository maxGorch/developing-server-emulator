package com.omsu.gorch825.models.Primitives;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private boolean success;
    private HttpStatus errorCode;
    private String errorMessage;

    private StackTraceElement[] details;

    public ApiResponse(boolean success, HttpStatus errorCode, String errorMessage, StackTraceElement[] details) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, null, null, null);
    }

    public static <T> ApiResponse<T> error(HttpStatus errorCode, String errorMessage, StackTraceElement[] details) {
        return new ApiResponse<>(false, errorCode, errorMessage, details);
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public StackTraceElement[] getDetails() {
        return details;
    }
}
