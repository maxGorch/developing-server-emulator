package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStudentGroupByIdRequest
{
    private Long id;
    @JsonCreator
    public GetStudentGroupByIdRequest(@JsonProperty("idGroup") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
