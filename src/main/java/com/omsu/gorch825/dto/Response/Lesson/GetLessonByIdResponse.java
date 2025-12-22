package com.omsu.gorch825.dto.Response.Lesson;

import java.util.List;

public class GetLessonByIdResponse {
    private Long id;
    private String date;
    private int pairNumber;
    private String teacherFullName;
    private String subjectName;
    private String groupName;
    private List<String> presentStudentFullNames; // Список ФИО присутствующих

    public GetLessonByIdResponse(Long id, String date, int pairNumber, String teacherFullName,
                                 String subjectName, String groupName, List<String> presentStudentFullNames) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherFullName = teacherFullName;
        this.subjectName = subjectName;
        this.groupName = groupName;
        this.presentStudentFullNames = presentStudentFullNames;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getPairNumber() {
        return pairNumber;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<String> getPresentStudentFullNames() {
        return presentStudentFullNames;
    }
}