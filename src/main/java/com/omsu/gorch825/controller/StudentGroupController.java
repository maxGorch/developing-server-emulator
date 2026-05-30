package com.omsu.gorch825.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.dto.Request.StudentGroup.EditStudentGroupRequest;
import com.omsu.gorch825.dto.Response.StudentGroup.AddStudentGroupResponse;
import com.omsu.gorch825.dto.Response.StudentGroup.EditStudentGroupResponse;
import com.omsu.gorch825.models.Primitives.ApiResponse;
import com.omsu.gorch825.service.StudentGroupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/group")
public class StudentGroupController {
    private StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @PostMapping
    public ApiResponse<AddStudentGroupResponse> addStudentGroup(@Valid @RequestBody AddStudentGroupRequest request) {
        return ApiResponse.success(studentGroupService.addStudentGroup(request));
    }

    @PatchMapping("/{id}")
    public ApiResponse<EditStudentGroupResponse> editStudentGroup(@Valid @RequestBody EditStudentGroupRequest request,
            @PathVariable Long id) {
        return ApiResponse.success(studentGroupService.editStudentGroup(request, id));
    }

}
