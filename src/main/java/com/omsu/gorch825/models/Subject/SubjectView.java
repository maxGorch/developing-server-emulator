package com.omsu.gorch825.models.Subject;

public class SubjectView {
    private Long id;
    private String nameDiscipline;

    public SubjectView(Long id, String nameDiscipline) {
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
