package com.omsu.gorch825.models.Student;

import com.omsu.gorch825.models.StudentGroup.StudentGroup;
import com.omsu.gorch825.models.StudentStatus;

import java.util.Objects;

public class Student {
    /*
      Написать следующий набор классов для внутреннего представления сущностей. Каждый
      класс включает в себя поле id — уникальный целочисленный идентификатор (может
      обращаться в null), конструктор по значениям всех полей, геттеры, equals и hashCode.
      2) «Студент»: хранит ФИО студента (по отдельности), статус студента (учится, в а/о,отчислен), группу (объект типа «Группа»).
    */
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private StudentGroup group;

    public Student()
    {}

    public Student(Long id, StudentGroup group, String firstName, String middleName, String lastName, StudentStatus status) {
        this.id = id;
        this.group = group;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;

        return Objects.equals(getId(), student.getId()) &&
                getFirstName().equals(student.getFirstName()) &&
                getMiddleName().equals(student.getMiddleName()) &&
                getLastName().equals(student.getLastName()) &&
                getStatus().equals(student.getStatus()) &&
                getGroup().equals(student.getGroup());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getGroup().hashCode();
        return result;
    }

}
