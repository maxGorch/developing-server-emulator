package com.omsu.gorch825.dto.Response.StudentGroup;

public class GetStudentGroupByIdResponse {
    private Long id;
    private String nameGroup;

    public GetStudentGroupByIdResponse(Long id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Long getId() { return id; }
    public String getNameGroup() { return nameGroup; }
}