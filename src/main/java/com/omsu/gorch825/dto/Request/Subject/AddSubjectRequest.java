package com.omsu.gorch825.dto.Request.Subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddSubjectRequest {
    @NotBlank(message = "nameSubject must not be blank")
    @Size(max = 100, message = "nameSubject must be at most 100 characters long")
    private String nameSubject;

    public AddSubjectRequest(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }
}
