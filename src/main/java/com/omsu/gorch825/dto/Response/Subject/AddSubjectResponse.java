package com.omsu.gorch825.dto.Response.Subject;

public class AddSubjectResponse {
    private Long id;
    private String nameSubject;

    public AddSubjectResponse(Long id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public Long getId() { return id; }
    public String getNameSubject() { return nameSubject; }
}