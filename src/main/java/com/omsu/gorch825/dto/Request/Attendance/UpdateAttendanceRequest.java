package com.omsu.gorch825.dto.Request.Attendance;

import java.util.List;

public class UpdateAttendanceRequest {
    private Long lessonId;
    private List<Long> studentIds; // ID присутствующих студентов [cite: 18]

    public UpdateAttendanceRequest(Long lessonId, List<Long> studentIds) {
        this.lessonId = lessonId;
        this.studentIds = studentIds;
    }

    public Long getLessonId() { return lessonId; }
    public List<Long> getStudentIds() { return studentIds; }
}