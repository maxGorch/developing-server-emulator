package com.omsu.gorch825.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.models.Primitives.ApiResponse;
import com.omsu.gorch825.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<?>> addStudent(@RequestBody AddStudentRequest request) {
        Long id = studentService.addStudent(request);

        if (id == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("BAD REQUEST", "Ошибка при добавлении студента", null));
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(id));
    }

}