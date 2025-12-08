package com.omsu.gorch825.API.view.Student;

public class StudentView {
    /*
        Написать набор классов для хранения данных визуального представления (view models)
        сущностей из п.1. Каждая view model содержит id соответствующей сущности и
        дополнительные данные.
        1) Представление студента хранит ФИО студента и название группы.
     */
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String groupName;

    public StudentView(Long id, String firstName, String middleName, String lastName, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.groupName = groupName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getGroupName() {
        return groupName;
    }
}
