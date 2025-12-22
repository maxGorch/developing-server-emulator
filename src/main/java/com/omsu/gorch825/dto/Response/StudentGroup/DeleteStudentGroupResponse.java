package com.omsu.gorch825.dto.Response.StudentGroup;

public class DeleteStudentGroupResponse {
    private String status;

    public DeleteStudentGroupResponse(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }
}