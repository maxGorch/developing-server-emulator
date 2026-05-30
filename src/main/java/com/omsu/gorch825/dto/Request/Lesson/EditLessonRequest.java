package com.omsu.gorch825.dto.Request.Lesson;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class EditLessonRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "date must not be blank")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "date must be in yyyy-MM-dd format")
    private String date;

    @Positive(message = "pairNumber must be positive")
    private int pairNumber;

    @NotNull(message = "teacherId must not be null")
    @Positive(message = "teacherId must be positive")
    private Long teacherId;

    @NotNull(message = "groupId must not be null")
    @Positive(message = "groupId must be positive")
    private Long groupId;

    @NotNull(message = "subjectId must not be null")
    @Positive(message = "subjectId must be positive")
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
