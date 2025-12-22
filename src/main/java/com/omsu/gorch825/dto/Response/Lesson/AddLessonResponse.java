package com.omsu.gorch825.dto.Response.Lesson;

public class AddLessonResponse {
    private Long id;
    private String date;
    private int pairNumber;

    public AddLessonResponse(Long id, String date, int pairNumber) {
        this.id = id;
        this.date = date;
        this.pairNumber = pairNumber;
    }

    public Long getId() { return id; }
    public String getDate() { return date; }
    public int getPairNumber() { return pairNumber; }
}
