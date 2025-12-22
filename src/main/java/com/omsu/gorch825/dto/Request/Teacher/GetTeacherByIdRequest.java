package com.omsu.gorch825.dto.Request.Teacher;

public class GetTeacherByIdRequest {
    private Long id;

    public GetTeacherByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}