package com.omsu.gorch825.dto.Request.Subject;

public class AddSubjectRequest {
    private String nameSubject;

    public AddSubjectRequest(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }
}