package com.omsu.gorch825.dto.Request.Student;

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
