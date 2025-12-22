package com.omsu.gorch825.controller;

import com.omsu.gorch825.dto.Request.Student.*;
import com.omsu.gorch825.dto.Response.Student.*; // Импортируем новые Response
import com.omsu.gorch825.models.Student.StudentView;
import com.omsu.gorch825.models.StudentStatus;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;
import com.omsu.gorch825.validation.Student.*;
import com.omsu.gorch825.models.ResponseEntity;
import com.omsu.gorch825.models.Student.Student;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;

import java.util.List;
import java.util.Objects;

public class StudentController
{
    private final IStudentRepositories repository;
    private final IGroupStudentRepositories studentGroupRepository;

    private final AddStudentRequestValidator validatorAddStudentRequest;
    private final GetStudentByIdRequestValidator validatorGetStudentByIdRequest;
    private final DeleteStudentRequestValidator validatorDeleteStudentRequest;
    private final EditStudentRequestValidator validatorEditStudentRequest;
    private final GetStudentsByGroupRequestValidator validatorGetStudentsByGroupRequest;

    public StudentController(
            IStudentRepositories repository,
            AddStudentRequestValidator validatorAddStudentRequest,
            IGroupStudentRepositories studentGroupRepository,
            GetStudentByIdRequestValidator validatorGetStudentByIdRequest,
            DeleteStudentRequestValidator validatorDeleteStudentRequest,
            EditStudentRequestValidator validatorEditStudentRequest,
            GetStudentsByGroupRequestValidator validatorGetStudentsByGroupRequest)
    {
        this.repository = repository;
        this.validatorAddStudentRequest = validatorAddStudentRequest;
        this.studentGroupRepository = studentGroupRepository;
        this.validatorGetStudentByIdRequest = validatorGetStudentByIdRequest;
        this.validatorDeleteStudentRequest = validatorDeleteStudentRequest;
        this.validatorEditStudentRequest = validatorEditStudentRequest;
        this.validatorGetStudentsByGroupRequest = validatorGetStudentsByGroupRequest;
    }

    public ResponseEntity<?> addStudent(AddStudentRequest request)
    {
        ResponseEntity<?> result = null;
        StudentGroup group = studentGroupRepository.getStudentGroupById(request.getIdStudentGroup());
        List<String> errors = validatorAddStudentRequest.validate(request);

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

            // Используем AddStudentResponse
            AddStudentResponse response = new AddStudentResponse(
                    modelId,
                    model.getFirstName(),
                    model.getMiddleName(),
                    model.getLastName(),
                    model.getStatus(),
                    model.getGroup().getNameGroup()
            );

            result = new ResponseEntity<>(response, 200);
        }
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
        List<String> errors = validatorGetStudentByIdRequest.validate(request);

        if(errors.isEmpty())
        {
            Student modelStudent = repository.getStudentById(request.getId());
            if(modelStudent == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors, 404);
            }
            else {
                // Используем GetStudentByIdResponse
                GetStudentByIdResponse response = new GetStudentByIdResponse(
                        modelStudent.getId(),
                        modelStudent.getFirstName(),
                        modelStudent.getMiddleName(),
                        modelStudent.getLastName(),
                        modelStudent.getStatus(),
                        modelStudent.getGroup().getNameGroup()
                );

                result = new ResponseEntity<>(response, 200);
            }
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }

        return result;
    }

    public ResponseEntity<?> getStudentsByGroup(GetStudentsByGroupRequest request)
    {
        ResponseEntity<?> result = null;
        List<String> errors = validatorGetStudentsByGroupRequest.validate(request);

        if(errors.isEmpty())
        {
            StudentGroup studentGroupById = studentGroupRepository.getStudentGroupById(request.getIdStudentGroup());
            if(studentGroupById == null)
            {
                errors.add("Student Group with id" + request.getIdStudentGroup() + " not found");
                result = new ResponseEntity<>(errors, 404);
            }
            else {
                List<Student> studentsByGroup = repository.getAllStudent();
                List<StudentView> viewList = studentsByGroup.stream()
                        .filter(s -> Objects.equals(s.getGroup().getId(), studentGroupById.getId()))
                        .map(s -> new StudentView(
                                s.getId(),
                                s.getFirstName(),
                                s.getMiddleName(),
                                s.getLastName(),
                                s.getGroup().getNameGroup()
                        ))
                        .toList();

                // Используем GetStudentsByGroupResponse
                result = new ResponseEntity<>(new GetStudentsByGroupResponse(viewList), 200);
            }
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }

        return result;
    }

    public ResponseEntity<?> deleteStudentUpdateStatusExpelled(DeleteStudentRequest request)
    {
        ResponseEntity<?> result = null;
        List<String> errors = validatorDeleteStudentRequest.validate(request);

        if (errors.isEmpty())
        {
            Student studentById = repository.getStudentById(request.getId());
            if (studentById == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors, 404);
            }
            else
            {
                studentById.setStatus(StudentStatus.EXPELLED);
                repository.editStudent(studentById);

                // Используем EditStudentResponse (так как это обновление статуса)
                EditStudentResponse response = new EditStudentResponse(
                        studentById.getId(),
                        studentById.getGroup().getId(),
                        studentById.getStatus(),
                        studentById.getFirstName(),
                        studentById.getMiddleName(),
                        studentById.getLastName()
                );
                result = new ResponseEntity<>(response, 200);
            }
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }

    public ResponseEntity<?> deleteStudentFromBd(DeleteStudentRequest request)
    {
        ResponseEntity<?> result = null;
        List<String> errors = validatorDeleteStudentRequest.validate(request);

        if (errors.isEmpty())
        {
            Student studentById = repository.getStudentById(request.getId());
            if (studentById == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors, 404);
            }
            else
            {
                repository.deleteStudent(studentById.getId());
                // Используем DeleteStudentResponse
                result = new ResponseEntity<>(new DeleteStudentResponse("Student deleted from database"), 204);
            }
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }

    public ResponseEntity<?> editStudent(EditStudentRequest request)
    {
        ResponseEntity<?> result = null;
        List <String> errors = validatorEditStudentRequest.validate(request);

        if(errors.isEmpty())
        {
            Student studentById = repository.getStudentById(request.getId());
            if (studentById == null)
            {
                errors.add("Student with id" + request.getId() + " not found");
                result = new ResponseEntity<>(errors, 404);
            }
            else
            {
                StudentGroup groupStudentById = studentGroupRepository.getStudentGroupById(request.getIdStudentGroup());
                if (groupStudentById == null) {
                    errors.add("Group with id " + request.getIdStudentGroup() + " not found");
                    result = new ResponseEntity<>(errors, 400);
                }
                else {
                    studentById.setGroup(groupStudentById);
                    studentById.setFirstName(request.getFirstName());
                    studentById.setMiddleName(request.getMiddleName());
                    studentById.setLastName(request.getLastName());
                    studentById.setStatus(request.getStatus());

                    repository.editStudent(studentById);

                    // Используем EditStudentResponse
                    EditStudentResponse response = new EditStudentResponse(
                            studentById.getId(),
                            studentById.getGroup().getId(),
                            studentById.getStatus(),
                            studentById.getFirstName(),
                            studentById.getMiddleName(),
                            studentById.getLastName()
                    );
                    result = new ResponseEntity<>(response, 200);
                }
            }
        }
        else
        {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }
}