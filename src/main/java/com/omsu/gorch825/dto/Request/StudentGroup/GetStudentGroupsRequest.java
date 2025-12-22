package com.omsu.gorch825.dto.Request.StudentGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStudentGroupsRequest
{
    private String nameGroup;
    @JsonCreator
    public GetStudentGroupsRequest(@JsonProperty("nameGroup") String nameGroup) {
        this.nameGroup = nameGroup;
    }
    public String getNameGroup(){return nameGroup;}
}
