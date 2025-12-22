package com.omsu.gorch825.dto.Response.Lesson;

import com.omsu.gorch825.models.Lesson.LessonView;

import java.util.List;

public class GetLessonsByTeacherResponse {
    private List<LessonView> lessons;

    public GetLessonsByTeacherResponse(List<LessonView> lessons) {
        this.lessons = lessons;
    }

    public List<LessonView> getLessons() { return lessons; }
}