package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omsu.gorch825.models.StudentStatus;

public class EditStudentRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private StudentStatus status;
    private Long idStudentGroup;

    @JsonCreator
    public EditStudentRequest(@JsonProperty("id") Long id,
                              @JsonProperty("idStudentGroup") Long idStudentGroup,
                              @JsonProperty("firstName") String firstName,
                              @JsonProperty("middleName") String middleName,
                              @JsonProperty("lastName") String lastName,
                              @JsonProperty("status") StudentStatus status) {
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
