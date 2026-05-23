package com.omsu.gorch825.models.StudentGroup;

import com.omsu.gorch825.models.Primitives.AuditableEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_group")
public class StudentGroupEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "group_name", nullable = false, length = 100)
    private String name;

    public StudentGroupEntity() {
    }

    public StudentGroupEntity(String name) {
        this.name = name;
    }
}
