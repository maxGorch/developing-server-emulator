package com.omsu.gorch825.dto.Request.Lesson;

public class GetLessonsByTeacherRequest {
    private String startDate;
    private String endDate;
    private Long teacherId;

    public GetLessonsByTeacherRequest(String startDate, String endDate, Long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public Long getTeacherId() { return teacherId; }
}
