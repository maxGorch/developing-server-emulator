package com.omsu.gorch825.dto.Request.Subject;

public class GetSubjectsRequest {
    private String nameFilter;

    public GetSubjectsRequest(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public String getNameFilter() {
        return nameFilter;
    }
}