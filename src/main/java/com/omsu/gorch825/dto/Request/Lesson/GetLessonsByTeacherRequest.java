package com.omsu.gorch825.dto.Request.Lesson;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class GetLessonsByTeacherRequest {
    @NotBlank(message = "startDate must not be blank")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "startDate must be in yyyy-MM-dd format")
    private String startDate;

    @NotBlank(message = "endDate must not be blank")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "endDate must be in yyyy-MM-dd format")
    private String endDate;

    @NotNull(message = "teacherId must not be null")
    @Positive(message = "teacherId must be positive")
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
