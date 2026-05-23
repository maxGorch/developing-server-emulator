package com.omsu.gorch825.models.Subject;

import com.omsu.gorch825.models.Primitives.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjectEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Long id;

    @Column(name = "name_subject", nullable = false, length = 100)
    private String nameSubject;

    public SubjectEntity() {

    }

    public SubjectEntity(Long id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }
}
