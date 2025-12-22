package com.omsu.gorch825.models.Attendance;

import java.util.List;

public class AttendanceView {
    private Long id;
    private String lessonTitle;
    private List<String> studentFullNames;

    public AttendanceView(Long id, String lessonTitle, List<String> studentFullNames) {
        this.id = id;
        this.lessonTitle = lessonTitle;
        this.studentFullNames = studentFullNames;
    }

    public Long getId() { return id; }
    public String getLessonTitle() { return lessonTitle; }
    public List<String> getStudentFullNames() { return studentFullNames; }
}