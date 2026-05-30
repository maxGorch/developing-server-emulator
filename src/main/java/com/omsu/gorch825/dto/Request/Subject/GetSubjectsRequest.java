package com.omsu.gorch825.dto.Request.Subject;

import jakarta.validation.constraints.Size;

public class GetSubjectsRequest {
    @Size(max = 100, message = "nameFilter must be at most 100 characters long")
    private String nameFilter;

    public GetSubjectsRequest(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public String getNameFilter() {
        return nameFilter;
    }
}
