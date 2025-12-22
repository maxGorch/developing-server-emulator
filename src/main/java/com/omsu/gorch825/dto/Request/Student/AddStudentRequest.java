package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omsu.gorch825.models.StudentStatus;

public class AddStudentRequest
{
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private Long idStudentGroup;
    @JsonCreator
    public AddStudentRequest(@JsonProperty("idStudentGroup") Long idStudentGroup,
                             @JsonProperty("firstName") String firstName,
                             @JsonProperty("middleName") String middleName,
                             @JsonProperty("lastName") String lastName,
                             @JsonProperty("status") StudentStatus status) {
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
