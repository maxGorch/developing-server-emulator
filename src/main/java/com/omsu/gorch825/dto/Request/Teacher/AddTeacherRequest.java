package com.omsu.gorch825.dto.Request.Teacher;

public class AddTeacherRequest {
    private String firstName;
    private String middleName;
    private String lastName;

    public AddTeacherRequest(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
}