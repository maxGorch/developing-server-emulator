package com.omsu.gorch825.dto.Response.Student;

import com.omsu.gorch825.models.StudentStatus;

public class GetStudentByIdResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private String groupName;

    public GetStudentByIdResponse(Long id, String firstName, String middleName, String lastName, StudentStatus status, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
        this.groupName = groupName;
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

    public StudentStatus getStatus() {
        return status;
    }

    public String getGroupName() {
        return groupName;
    }
}