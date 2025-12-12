package com.omsu.gorch825.Domain.models.StudentGroup;

public class GetStudentGroupByIdRequest
{
    private Long id;

    public GetStudentGroupByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
