package com.omsu.gorch825.dto.Response.Subject;

public class DeleteSubjectResponse {
    private String message;

    public DeleteSubjectResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}