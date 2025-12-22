package com.omsu.gorch825.models.StudentGroup;

import java.util.Objects;

public class StudentGroup {
    /*
      Написать следующий набор классов для внутреннего представления сущностей. Каждый
      класс включает в себя поле id — уникальный целочисленный идентификатор (может
      обращаться в null), конструктор по значениям всех полей, геттеры, equals и hashCode.
      1) «Группа студентов»: хранит название группы.
    */
    private Long id;
    private String nameGroup;

    public StudentGroup()
    {

    }

    public StudentGroup(Long id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Long getId() {
        return id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof StudentGroup that)) return false;

        return Objects.equals(getId(), that.getId()) && getNameGroup().equals(that.getNameGroup());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getNameGroup().hashCode();
        return result;
    }
}
