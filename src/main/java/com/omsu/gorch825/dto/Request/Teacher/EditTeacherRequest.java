package com.omsu.gorch825.dto.Request.Teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EditTeacherRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotBlank(message = "firstName must not be blank")
    @Size(max = 100, message = "firstName must be at most 100 characters long")
    private String firstName;

    @NotBlank(message = "middleName must not be blank")
    @Size(max = 100, message = "middleName must be at most 100 characters long")
    private String middleName;

    @NotBlank(message = "lastName must not be blank")
    @Size(max = 100, message = "lastName must be at most 100 characters long")
    private String lastName;

    public EditTeacherRequest(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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
}
