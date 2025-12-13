package com.omsu.gorch825.dto.Request.Student;

import com.omsu.gorch825.models.StudentStatus;

public class AddStudentRequest
{
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private Long idStudentGroup;

    public AddStudentRequest(Long idStudentGroup, String firstName, String middleName, String lastName, StudentStatus status) {
        this.idStudentGroup = idStudentGroup;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getIdStudentGroup() {
        return idStudentGroup;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
