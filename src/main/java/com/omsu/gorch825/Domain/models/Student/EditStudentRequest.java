package com.omsu.gorch825.Domain.models.Student;

import com.omsu.gorch825.StudentStatus;

public class EditStudentRequest
{
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private Long idStudentGroup;

    public EditStudentRequest(Long id, Long idStudentGroup, StudentStatus status, String lastName, String middleName, String firstName) {
        this.id = id;
        this.idStudentGroup = idStudentGroup;
        this.status = status;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
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

    public StudentStatus getStatus() {
        return status;
    }

    public Long getIdStudentGroup() {
        return idStudentGroup;
    }
}
