package com.omsu.gorch825.models.Attendance;

import com.omsu.gorch825.models.Lesson.Lesson;
import com.omsu.gorch825.models.Student.Student;
import java.util.List;
import java.util.Objects;

public class Attendance {
    private Long id;
    private Lesson lesson;
    private List<Student> presentStudents;

    public Attendance(Long id, Lesson lesson, List<Student> presentStudents) {
        this.id = id;
        this.lesson = lesson;
        this.presentStudents = presentStudents;
    }

    public Long getId() { return id; }
    public Lesson getLesson() { return lesson; }
    public List<Student> getPresentStudents() { return presentStudents; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}