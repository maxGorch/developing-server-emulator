package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetStudentByIdRequest
{
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;
@JsonCreator
    public GetStudentByIdRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
