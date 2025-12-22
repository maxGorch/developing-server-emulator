package com.omsu.gorch825.dto.Response.Student;

public class DeleteStudentResponse {
    private String message;

    public DeleteStudentResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}