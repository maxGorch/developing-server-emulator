package com.omsu.gorch825.Domain.models.Student;

public class GetStudentByIdRequest
{
    private Long id;

    public GetStudentByIdRequest(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
