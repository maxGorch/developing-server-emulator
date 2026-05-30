package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddStudentGroupRequest {
    @NotBlank(message = "nameGroup must not be blank")
    @Size(max = 100, message = "nameGroup must be at most 100 characters long")
    private String nameGroup;

    @JsonCreator
    public AddStudentGroupRequest(@JsonProperty("nameGroup") String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }
}
