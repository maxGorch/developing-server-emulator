package com.omsu.gorch825.dto.Request.Subject;

public class DeleteSubjectRequest {
    private Long id;

    public DeleteSubjectRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}