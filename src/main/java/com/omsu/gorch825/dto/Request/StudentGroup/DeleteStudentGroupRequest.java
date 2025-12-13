package com.omsu.gorch825.dto.Request.StudentGroup;

public class DeleteStudentGroupRequest
{
    private Long id;

    public DeleteStudentGroupRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
