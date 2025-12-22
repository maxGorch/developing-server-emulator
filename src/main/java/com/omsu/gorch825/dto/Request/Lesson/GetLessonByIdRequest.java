package com.omsu.gorch825.dto.Request.Lesson;

public class GetLessonByIdRequest {
    private Long id;

    public GetLessonByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() { return id; }
}