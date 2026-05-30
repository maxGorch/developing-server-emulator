package com.omsu.gorch825.dto.Request.Teacher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetTeacherByIdRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    public GetTeacherByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
