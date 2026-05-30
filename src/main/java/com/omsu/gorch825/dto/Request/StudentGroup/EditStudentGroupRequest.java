package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EditStudentGroupRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "newNameStudentGroup must not be blank")
    @Size(max = 100, message = "newNameStudentGroup must be at most 100 characters long")
    private String newNameStudentGroup;

    @JsonCreator
    public EditStudentGroupRequest(@JsonProperty("idGroup") Long id,
            @JsonProperty("newNameStudentGroup") String newNameStudentGroup) {
        this.id = id;
        this.newNameStudentGroup = newNameStudentGroup;
    }

    public Long getId() {
        return id;
    }

    public String getNewNameStudentGroup() {
        return newNameStudentGroup;
    }
}
