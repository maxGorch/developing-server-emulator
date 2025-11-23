package com.omsu.gorch825.Response.GroupStudent;

public class GroupStudentView {
    private Long id;
    private String nameGroup;

    public GroupStudentView(Long id, String nameGroup) {
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
