package com.omsu.gorch825.dto.Request.Lesson;

public class DeleteLessonRequest {
    private Long id;

    public DeleteLessonRequest(Long id) {
        this.id = id;
    }

    public Long getId() { return id; }
}