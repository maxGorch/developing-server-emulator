package com.omsu.gorch825.dto.Response.StudentGroup;

import com.omsu.gorch825.models.StudentGroup.StudentGroupView;

import java.util.List;

public class GetStudentGroupsResponse {
    private List<StudentGroupView> groups;

    public GetStudentGroupsResponse(List<StudentGroupView> groups) {
        this.groups = groups;
    }

    public List<StudentGroupView> getGroups() { return groups; }
}

