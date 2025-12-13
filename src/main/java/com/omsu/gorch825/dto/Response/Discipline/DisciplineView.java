package com.omsu.gorch825.dto.Response.Discipline;

public class DisciplineView {
    private Long id;
    private String nameDiscipline;

    public DisciplineView(Long id, String nameDiscipline) {
        this.id = id;
        this.nameDiscipline = nameDiscipline;
    }

    public Long getId() {
        return id;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }
}
