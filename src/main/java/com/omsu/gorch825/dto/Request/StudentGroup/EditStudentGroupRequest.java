package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EditStudentGroupRequest
{
    private Long id;
    private String newNameStudentGroup;
    @JsonCreator
    public EditStudentGroupRequest(@JsonProperty("idGroup")Long id,@JsonProperty("newNameStudentGroup") String newNameStudentGroup) {
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
