package com.omsu.gorch825.dto.Request.Student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omsu.gorch825.models.Enums.StudentStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AddStudentRequest {

    @NotBlank(message = "firstName must not be blank")
    @Size(max = 100, message = "firstName must be at most 100 characters long")
    private String firstName;

    @NotBlank(message = "middleName must not be blank")
    @Size(max = 100, message = "middleName must be at most 100 characters long")
    private String middleName;

    @NotBlank(message = "lastName must not be blank")
    @Size(max = 100, message = "lastName must be at most 100 characters long")
    private String lastName;

    @NotNull(message = "status must not be null")
    private StudentStatus status;

    @NotNull(message = "idStudentGroup must not be null")
    @Positive(message = "idStudentGroup must be positive")
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
