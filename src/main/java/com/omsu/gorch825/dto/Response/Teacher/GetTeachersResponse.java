package com.omsu.gorch825.dto.Response.Teacher;

import com.omsu.gorch825.models.Teacher.TeacherView;

import java.util.List;

public class GetTeachersResponse {
    private List<TeacherView> teachers;

    public GetTeachersResponse(List<TeacherView> teachers) {
        this.teachers = teachers;
    }

    public List<TeacherView> getTeachers() { return teachers; }
}
