package com.omsu.gorch825.dto.Response.Teacher;

public class DeleteTeacherResponse {
    private String message;

    public DeleteTeacherResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}