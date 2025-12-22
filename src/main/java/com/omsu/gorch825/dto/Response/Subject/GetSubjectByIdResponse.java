package com.omsu.gorch825.dto.Response.Subject;

public class GetSubjectByIdResponse {
    private Long id;
    private String nameSubject;

    public GetSubjectByIdResponse(Long id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public Long getId() { return id; }
    public String getNameSubject() { return nameSubject; }
}