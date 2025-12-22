package com.omsu.gorch825.dto.Response.StudentGroup;

public class AddStudentGroupResponse {
    private Long id;
    private String nameGroup;

    public AddStudentGroupResponse(Long id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Long getId() { return id; }
    public String getNameGroup() { return nameGroup; }
}