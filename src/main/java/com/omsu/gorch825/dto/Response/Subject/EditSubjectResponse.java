package com.omsu.gorch825.dto.Response.Subject;

public class EditSubjectResponse {
    private Long id;
    private String nameSubject;

    public EditSubjectResponse(Long id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public Long getId() { return id; }
    public String getNameSubject() { return nameSubject; }
}