package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetStudentsByGroupRequest
{
    @NotNull(message = "idStudentGroup must not be null")
    @Positive(message = "idStudentGroup must be positive")
    private Long idStudentGroup;
@JsonCreator
    public GetStudentsByGroupRequest(@JsonProperty("idStudentGroup") Long idStudentGroup) {
        this.idStudentGroup = idStudentGroup;
    }
    public Long getIdStudentGroup() {
        return idStudentGroup;
    }
}
