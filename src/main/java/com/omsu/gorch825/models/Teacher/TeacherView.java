package com.omsu.gorch825.models.Teacher;

public class TeacherView
{
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public TeacherView(Long id, String firstName, String middleName, String lastName) {
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
}
