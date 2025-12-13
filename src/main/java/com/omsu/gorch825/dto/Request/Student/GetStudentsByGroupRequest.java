package com.omsu.gorch825.dto.Request.Student;

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
