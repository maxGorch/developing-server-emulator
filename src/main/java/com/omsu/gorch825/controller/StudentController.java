package com.omsu.gorch825.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.dto.Request.Student.EditStudentRequest;
import com.omsu.gorch825.dto.Response.Student.AddStudentResponse;
import com.omsu.gorch825.dto.Response.Student.EditStudentResponse;
import com.omsu.gorch825.models.Primitives.ApiResponse;
import com.omsu.gorch825.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ApiResponse<AddStudentResponse> addStudent(@Valid @RequestBody AddStudentRequest request) {
        return ApiResponse.success(studentService.addStudent(request));
    }

    @PatchMapping("/{id}")
    public ApiResponse<EditStudentResponse> editStudent(@Valid @RequestBody EditStudentRequest request,
            @PathVariable Long id) {
        return ApiResponse.success(studentService.editStudent(request, id));
    }

}