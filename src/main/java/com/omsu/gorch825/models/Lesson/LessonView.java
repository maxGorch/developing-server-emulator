package com.omsu.gorch825.models.Lesson;

public class LessonView {
    private Long id;
    private String date;
    private int pairNumber;
    private String teacherFullName;

    public LessonView(Long id, String date, int pairNumber, String teacherFullName) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherFullName = teacherFullName;
    }

    public Long getId() { return id; }
    public String getDate() { return date; }
    public int getPairNumber() { return pairNumber; }
    public String getTeacherFullName() { return teacherFullName; }
}