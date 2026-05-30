package com.omsu.gorch825.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.dto.Request.StudentGroup.EditStudentGroupRequest;
import com.omsu.gorch825.models.Primitives.ApiResponse;
import com.omsu.gorch825.service.StudentGroupService;

@RestController
@RequestMapping("/group")
public class StudentGroupController {
    private StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @PostMapping
    public void addStudentGroup(@RequestBody AddStudentGroupRequest request) {
        studentGroupService.addStudentGroup(request);
    }

    @PatchMapping
    public void editStudentGroup(@RequestBody EditStudentGroupRequest request) {
        studentGroupService.editStudentGroup(request);
    }

}