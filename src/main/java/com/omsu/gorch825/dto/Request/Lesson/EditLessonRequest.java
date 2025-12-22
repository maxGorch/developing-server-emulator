package com.omsu.gorch825.dto.Request.Lesson;

public class EditLessonRequest {
    private Long id;
    private String date;
    private int pairNumber;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;

    public EditLessonRequest(Long id, String date, int pairNumber, Long teacherId, Long groupId, Long subjectId) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public Long getId() { return id; }
    public String getDate() { return date; }
    public int getPairNumber() { return pairNumber; }
    public Long getTeacherId() { return teacherId; }
    public Long getGroupId() { return groupId; }
    public Long getSubjectId() { return subjectId; }
}
