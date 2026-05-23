package com.omsu.gorch825.models.Attendance;

import java.util.List;

import com.omsu.gorch825.models.Lesson.LessonEntity;
import com.omsu.gorch825.models.Primitives.AuditableEntity;
import com.omsu.gorch825.models.Student.StudentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson_attendance")
public class AttendanceEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_attendance_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private LessonEntity lessonId;

    @OneToMany
    @JoinColumn(name = "student_id ", nullable = false)
    private List<StudentEntity> presentStudentIds; // Список ID студентов

    public AttendanceEntity(LessonEntity lessonId, List<StudentEntity> presentStudentIds) {
        this.lessonId = lessonId;
        this.presentStudentIds = presentStudentIds;
    }
}