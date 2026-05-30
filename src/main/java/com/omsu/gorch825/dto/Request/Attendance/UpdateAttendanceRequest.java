package com.omsu.gorch825.dto.Request.Attendance;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateAttendanceRequest {
    @NotNull(message = "lessonId must not be null")
    @Positive(message = "lessonId must be positive")
    private Long lessonId;

    @NotEmpty(message = "studentIds must not be empty")
    private List<Long> studentIds; // ID присутствующих студентов [cite: 18]

    public UpdateAttendanceRequest(Long lessonId, List<Long> studentIds) {
        this.lessonId = lessonId;
        this.studentIds = studentIds;
    }

    public Long getLessonId() { return lessonId; }
    public List<Long> getStudentIds() { return studentIds; }
}
