package com.omsu.gorch825.dto.Response.Student;

import com.omsu.gorch825.models.Student.StudentView;

import java.util.List;

public class GetStudentsByGroupResponse {
    private List<StudentView> students;

    public GetStudentsByGroupResponse(List<StudentView> students) {
        this.students = students;
    }

    public List<StudentView> getStudents() { return students; }
}