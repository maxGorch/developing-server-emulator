package com.omsu.gorch825.dto.Request.Student;

public class DeleteStudentRequest
{
    private Long id;

    public DeleteStudentRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
