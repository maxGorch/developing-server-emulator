package com.omsu.gorch825.dto.Request.Subject;

public class GetSubjectByIdRequest {
    private Long id;

    public GetSubjectByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}