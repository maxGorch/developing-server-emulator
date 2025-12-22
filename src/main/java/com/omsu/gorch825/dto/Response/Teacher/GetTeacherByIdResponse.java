package com.omsu.gorch825.dto.Response.Teacher;

public class GetTeacherByIdResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public GetTeacherByIdResponse(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
}