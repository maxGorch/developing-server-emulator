package com.omsu.gorch825.models.Student;

import java.time.LocalDateTime;

public class StudentEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long groupId; // Ссылка на ID группы
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentEntity(Long id, String firstName, String lastName, String middleName, Long groupId, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
