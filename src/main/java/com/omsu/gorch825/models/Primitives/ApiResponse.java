package com.omsu.gorch825.models.Primitives;

import java.util.List;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String errorCode;
    private String errorMessage;

    private List<String> details;

    public ApiResponse(boolean success, T data, String errorCode, String errorMessage, List<String> details) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null, null, null);
    }

    public static <T> ApiResponse<T> error(String errorCode, String errorMessage, List<String> details) {
        return new ApiResponse<>(false, null, errorCode, errorMessage, details);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getDetails() {
        return details;
    }
}
