package com.omsu.gorch825.models.Teacher;

import java.util.Objects;

public class Teacher
{
    /*
      Написать следующий набор классов для внутреннего представления сущностей. Каждый
      класс включает в себя поле id — уникальный целочисленный идентификатор (может
      обращаться в null), конструктор по значениям всех полей, геттеры, equals и hashCode.
      3) «Преподаватель»: ФИО преподавателя.
    */
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Teacher(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Teacher teacher)) return false;

        return Objects.equals(getId(), teacher.getId()) &&
                Objects.equals(getFirstName(), teacher.getFirstName()) &&
                Objects.equals(getMiddleName(), teacher.getMiddleName()) &&
                Objects.equals(getLastName(), teacher.getLastName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getFirstName());
        result = 31 * result + Objects.hashCode(getMiddleName());
        result = 31 * result + Objects.hashCode(getLastName());
        return result;
    }
}
