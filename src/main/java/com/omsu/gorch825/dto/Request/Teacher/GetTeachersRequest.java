package com.omsu.gorch825.dto.Request.Teacher;

public class GetTeachersRequest {
    private Long idGroup;

    public GetTeachersRequest(Long idGroup) {
        this.idGroup = idGroup;
    }

    public Long getIdGroup() {
        return idGroup;
    }
}