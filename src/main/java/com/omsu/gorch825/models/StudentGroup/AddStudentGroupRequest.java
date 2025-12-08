package com.omsu.gorch825.models.StudentGroup;


public class AddStudentGroupRequest
{
    private String nameGroup;

    public AddStudentGroupRequest(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }
}
