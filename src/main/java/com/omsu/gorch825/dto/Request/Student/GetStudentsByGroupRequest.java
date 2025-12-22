package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStudentsByGroupRequest
{
    private Long idStudentGroup;
@JsonCreator
    public GetStudentsByGroupRequest(@JsonProperty("idStudentGroup") Long idStudentGroup) {
        this.idStudentGroup = idStudentGroup;
    }
    public Long getIdStudentGroup() {
        return idStudentGroup;
    }
}
