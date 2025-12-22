package com.omsu.gorch825.models.Attendance;

import java.time.LocalDateTime;
import java.util.List;

public class AttendanceEntity {
    private Long id;
    private Long lessonId;
    private List<Long> presentStudentIds; // Список ID студентов
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AttendanceEntity(Long id, Long lessonId, List<Long> presentStudentIds) {
        this.id = id;
        this.lessonId = lessonId;
        this.presentStudentIds = presentStudentIds;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}