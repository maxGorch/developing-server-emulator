package com.omsu.gorch825.dto.Response.Subject;

import com.omsu.gorch825.models.Subject.SubjectView;

import java.util.List;

public class GetSubjectsResponse {
    private List<SubjectView> subjects;

    public GetSubjectsResponse(List<SubjectView> subjects) {
        this.subjects = subjects;
    }

    public List<SubjectView> getSubjects() { return subjects; }
}
