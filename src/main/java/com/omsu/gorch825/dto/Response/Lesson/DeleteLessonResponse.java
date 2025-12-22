package com.omsu.gorch825.dto.Response.Lesson;

public class DeleteLessonResponse {
    private String message;

    public DeleteLessonResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}