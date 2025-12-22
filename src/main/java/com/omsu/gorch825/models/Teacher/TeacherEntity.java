package com.omsu.gorch825.models.Teacher;

import java.time.LocalDateTime;

public class TeacherEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TeacherEntity(Long id, String firstName, String lastName, String middleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}