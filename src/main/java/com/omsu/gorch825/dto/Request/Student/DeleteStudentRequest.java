package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteStudentRequest
{
    private Long id;
    @JsonCreator
    public DeleteStudentRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
