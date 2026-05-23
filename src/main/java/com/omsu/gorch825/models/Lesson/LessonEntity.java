package com.omsu.gorch825.models.Lesson;

import java.time.LocalDate;

import com.omsu.gorch825.models.Primitives.AuditableEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroupEntity;
import com.omsu.gorch825.models.Subject.SubjectEntity;
import com.omsu.gorch825.models.Teacher.TeacherEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson")
public class LessonEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", nullable = false)
    private Long id;

    @Column(name = "lesson_date", nullable = false)
    private LocalDate date;

    @Column(name = "pair_number", nullable = false)
    private int pairNumber;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherEntity teacherId;

    @OneToOne
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroupEntity groupId;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subjectId;

    public LessonEntity(Long id, LocalDate date, int pairNumber, TeacherEntity teacherId, StudentGroupEntity groupId,
            SubjectEntity subjectId) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }
}
