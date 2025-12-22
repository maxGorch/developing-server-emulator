package com.omsu.gorch825.dto.Response.Student;

import com.omsu.gorch825.models.StudentStatus;

public class EditStudentResponse
{
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private Long idStudentGroup;

    public EditStudentResponse(Long id, Long idStudentGroup, StudentStatus status, String lastName, String middleName, String firstName) {
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
