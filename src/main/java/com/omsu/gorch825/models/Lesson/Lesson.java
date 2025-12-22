package com.omsu.gorch825.models.Lesson;

import com.omsu.gorch825.models.Teacher.Teacher;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;

import java.util.Objects;

public class Lesson {
    private Long id;
    private String date;
    private int pairNumber;
    private Teacher teacher;
    private StudentGroup group;

    public Lesson(Long id, String date, int pairNumber, Teacher teacher, StudentGroup group) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
        this.teacher = teacher;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getPairNumber() {
        return pairNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public StudentGroup getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}