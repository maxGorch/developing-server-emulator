package com.omsu.gorch825.Domain.models.Student;

public class GetStudentsByGroupRequest
{
    private Long idStudentGroup;

    public GetStudentsByGroupRequest(Long idStudentGroup) {
        this.idStudentGroup = idStudentGroup;
    }
    public Long getIdStudentGroup() {
        return idStudentGroup;
    }
}
