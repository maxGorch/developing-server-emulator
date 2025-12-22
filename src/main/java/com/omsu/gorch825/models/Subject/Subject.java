package com.omsu.gorch825.models.Subject;

import java.util.Objects;

public class Subject
{
     /*
      Написать следующий набор классов для внутреннего представления сущностей. Каждый
      класс включает в себя поле id — уникальный целочисленный идентификатор (может
      обращаться в null), конструктор по значениям всех полей, геттеры, equals и hashCode.
      4) «Дисциплина»: название дисциплины.
    */
    private Long id;
    private String nameDiscipline;

    public Subject(Long id, String nameDiscipline) {
        this.id = id;
        this.nameDiscipline = nameDiscipline;
    }

    public Long getId() {
        return id;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Subject that)) return false;

        return Objects.equals(getId(), that.getId()) && Objects.equals(getNameDiscipline(), that.getNameDiscipline());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getNameDiscipline());
        return result;
    }
}
