package com.omsu.gorch825.dto.Request.Subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EditSubjectRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "newNameSubject must not be blank")
    @Size(max = 100, message = "newNameSubject must be at most 100 characters long")
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
