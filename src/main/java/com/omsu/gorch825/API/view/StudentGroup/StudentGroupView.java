package com.omsu.gorch825.API.view.StudentGroup;

public class StudentGroupView {
    private Long id;
    private String nameGroup;

    public StudentGroupView(Long id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Long getId() {
        return id;
    }

    public String getNameGroup() {
        return nameGroup;
    }
}
