package com.omsu.gorch825.dto.Request.StudentGroup;

public class EditStudentGroupRequest
{
    private Long id;
    private String newNameStudentGroup;

    public EditStudentGroupRequest(Long id, String newNameStudentGroup) {
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
