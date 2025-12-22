package com.omsu.gorch825.dto.Request.Subject;

public class EditSubjectRequest {
    private Long id;
    private String newNameSubject;

    public EditSubjectRequest(Long id, String newNameSubject) {
        this.id = id;
        this.newNameSubject = newNameSubject;
    }

    public Long getId() {
        return id;
    }

    public String getNewNameSubject() {
        return newNameSubject;
    }
}