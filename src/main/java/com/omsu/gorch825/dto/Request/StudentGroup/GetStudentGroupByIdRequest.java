package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetStudentGroupByIdRequest
{
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;
    @JsonCreator
    public GetStudentGroupByIdRequest(@JsonProperty("idGroup") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
