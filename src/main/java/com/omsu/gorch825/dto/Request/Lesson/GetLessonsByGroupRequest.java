package com.omsu.gorch825.dto.Request.Lesson;

public class GetLessonsByGroupRequest {
    private String startDate;
    private String endDate;
    private Long groupId;

    public GetLessonsByGroupRequest(String startDate, String endDate, Long groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }

    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public Long getGroupId() { return groupId; }
}
