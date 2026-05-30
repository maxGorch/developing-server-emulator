package com.omsu.gorch825.dto.Request.Teacher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetTeachersRequest {
    @NotNull(message = "idGroup must not be null")
    @Positive(message = "idGroup must be positive")
    private Long idGroup;

    public GetTeachersRequest(Long idGroup) {
        this.idGroup = idGroup;
    }

    public Long getIdGroup() {
        return idGroup;
    }
}
