package com.omsu.gorch825.dto.Request.StudentGroup;

public class GetStudentGroupsRequest
{
    private String nameGroup;

    public GetStudentGroupsRequest(String nameGroup) {
        this.nameGroup = nameGroup;
    }
    public String getNameGroup(){return nameGroup;}
}
