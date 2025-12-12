package com.omsu.gorch825.Domain.models.StudentGroup;

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
