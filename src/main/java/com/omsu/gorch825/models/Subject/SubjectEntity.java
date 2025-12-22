package com.omsu.gorch825.models.Subject;

import java.time.LocalDateTime;

public class SubjectEntity {
    private Long id;
    private String nameSubject;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SubjectEntity(Long id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
