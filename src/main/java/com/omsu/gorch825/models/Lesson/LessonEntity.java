package com.omsu.gorch825.models.Lesson;

import java.time.LocalDateTime;

public class LessonEntity {
    private Long id;
    private String date;
    private int pairNumber;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LessonEntity(Long id, String date, int pairNumber, Long teacherId, Long groupId, Long subjectId) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
