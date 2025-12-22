package com.omsu.gorch825.dto.Response.Attendance;

public class UpdateAttendanceResponse {
    private String message;
    private int presentCount; // Количество отмеченных студентов

    public UpdateAttendanceResponse(String message, int presentCount) {
        this.message = message;
        this.presentCount = presentCount;
    }

    public String getMessage() { return message; }
    public int getPresentCount() { return presentCount; }
}