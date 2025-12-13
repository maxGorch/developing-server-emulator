package com.omsu.gorch825.controller;

import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.dto.Request.Student.DeleteStudentRequest;
import com.omsu.gorch825.dto.Request.Student.GetStudentByIdRequest;
import com.omsu.gorch825.models.StudentStatus;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;
import com.omsu.gorch825.validation.Student.AddStudentRequestValidator;
import com.omsu.gorch825.models.ResponseEntity;
import com.omsu.gorch825.models.Student.Student;
import com.omsu.gorch825.dto.Response.Student.StudentView;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;
import com.omsu.gorch825.validation.Student.DeleteStudentRequestValidator;
import com.omsu.gorch825.validation.Student.GetStudentByIdRequestValidator;

import java.util.List;

public class StudentController
{
    private final IStudentRepositories repository;
    private final IGroupStudentRepositories studentGroupRepository;

    private final AddStudentRequestValidator validatorAddStudentRequest;
    private final GetStudentByIdRequestValidator validatorGetStudentByIdRequest;
    private final DeleteStudentRequestValidator validatorDeleteStudentRequest;

    public StudentController(
            IStudentRepositories repository,
            AddStudentRequestValidator validatorAddStudentRequest,
            IGroupStudentRepositories studentGroupRepository,
            GetStudentByIdRequestValidator validatorGetStudentByIdRequest, DeleteStudentRequestValidator validatorDeleteStudentRequest)
    {
        this.repository = repository;
        this.validatorAddStudentRequest = validatorAddStudentRequest;
        this.studentGroupRepository = studentGroupRepository;
        this.validatorGetStudentByIdRequest = validatorGetStudentByIdRequest;
        this.validatorDeleteStudentRequest = validatorDeleteStudentRequest;
    }
    public ResponseEntity<?> addStudent(AddStudentRequest request)
    {
        ResponseEntity<?> result = null;
        StudentGroup group = studentGroupRepository.getStudentGroupById(request.getIdStudentGroup());
        // 1. Валидация
        List<String> errors = validatorAddStudentRequest.validate(request);
        // 2. Сохранение и возврат (статус 200)
        if(errors.isEmpty() && group != null)
        {
            Student model = new Student(
                    null,
                    group,
                    request.getFirstName(),
                    request.getMiddleName(),
                    request.getLastName(),
                    request.getStatus()
            );

            Long modelId = repository.addStudent(model);

            StudentView view = new StudentView(
                    modelId,
                    model.getFirstName(),
                    model.getMiddleName(),
                    model.getLastName(),
                    model.getGroup().getNameGroup()
            );

            result = new ResponseEntity<>(view,200);

        }
        // 3. Проверка ошибок (статус 400)
        else if (group == null){
            errors.add("Group with ID " + request.getIdStudentGroup() + " not found");
            result = new ResponseEntity<>(errors, 400);
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }

        return result;
    }

    public ResponseEntity<?> getStudentById(GetStudentByIdRequest request)
    {
        ResponseEntity<?> result = null;
        // 1. Валидация
        List<String> errors = validatorGetStudentByIdRequest.validate(request);
        // 2. Сохранение и возврат (статус 200)
        if(errors.isEmpty())
        {
            Student modelStudent = repository.getStudentById(request.getId());
            // 3. Проверка на существование студента (статус 404 - Not Found)
            if(modelStudent == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors,404);
            }
            else {
                StudentView view = new StudentView(
                        modelStudent.getId(),
                        modelStudent.getFirstName(),
                        modelStudent.getMiddleName(),
                        modelStudent.getLastName(),
                        modelStudent.getGroup().getNameGroup()
                );

                result = new ResponseEntity<>(view,200);
            }
        }
        // 4. Проверка ошибок (статус 400)
        else
        {
            result = new ResponseEntity<>(errors,400);
        }

        return result;
    }

    public ResponseEntity<?> deleteStudent(DeleteStudentRequest request)
    {
        ResponseEntity<?> result = null;

        List<String> errors = validatorDeleteStudentRequest.validate(request);

        if (errors.isEmpty())
        {
           Student studentById = repository.getStudentById(request.getId());
            // 3. Проверка на существование студента (статус 404 - Not Found)
            if (studentById == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors,404);
            }
            else
            {
                studentById.setStatus(StudentStatus.EXPELLED);//Отчислен

                repository.editStudent(studentById);

                StudentView view = new StudentView(
                        studentById.getId(),
                        studentById.getFirstName(),
                        studentById.getMiddleName(),
                        studentById.getLastName(),
                        studentById.getGroup().getNameGroup()
                );
                result = new ResponseEntity<>(view,200);
            }
        }
        // 4. Проверка ошибок (статус 400)
        else
        {
            result = new ResponseEntity<>(errors,400);
        }
        return result;
    }
}
