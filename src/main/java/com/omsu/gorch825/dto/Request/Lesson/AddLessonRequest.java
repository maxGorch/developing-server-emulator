package com.omsu.gorch825.dto.Request.Lesson;

public class AddLessonRequest {
    private String date;
    private int pairNumber;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;

    public AddLessonRequest(String date, int pairNumber, Long teacherId, Long groupId, Long subjectId) {
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public String getDate() { return date; }
    public int getPairNumber() { return pairNumber; }
    public Long getTeacherId() { return teacherId; }
    public Long getGroupId() { return groupId; }
    public Long getSubjectId() { return subjectId; }
}
