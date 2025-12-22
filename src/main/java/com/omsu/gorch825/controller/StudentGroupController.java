package com.omsu.gorch825.controller;

import com.omsu.gorch825.dto.Request.StudentGroup.*;
import com.omsu.gorch825.dto.Response.StudentGroup.*;
import com.omsu.gorch825.models.Student.Student;
import com.omsu.gorch825.models.StudentGroup.StudentGroupView;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.repository.IStudentRepositories;
import com.omsu.gorch825.validation.StudentGroup.*;
import com.omsu.gorch825.models.ResponseEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;

import java.util.List;
import java.util.Objects;

public class StudentGroupController {
    private final IGroupStudentRepositories repository;
    private final IStudentRepositories repositoryStudents;

    private final AddStudentGroupRequestValidator validatorAddStudentGroupRequest;
    private final GetStudentGroupsRequestValidator validatorGetStudentGroupsRequest;
    private final DeleteStudentGroupRequestValidator validatorDeleteStudentGroupRequest;
    private final EditStudentGroupRequestValidator validatorEditStudentGroupRequest;
    private final GetStudentGroupByIdRequestValidator validatorGetStudentGroupByIdRequest;

    public StudentGroupController(IGroupStudentRepositories repository, IStudentRepositories repositoryStudents,
                                  AddStudentGroupRequestValidator validator, GetStudentGroupsRequestValidator validatorGetStudentGroupsRequest, DeleteStudentGroupRequestValidator validatorDeleteStudentGroupRequest, EditStudentGroupRequestValidator validatorEditStudentGroupRequest, GetStudentGroupByIdRequestValidator validatorGetStudentGroupByIdRequest) {
        this.repository = repository;
        this.repositoryStudents = repositoryStudents;
        this.validatorAddStudentGroupRequest = validator;
        this.validatorGetStudentGroupsRequest = validatorGetStudentGroupsRequest;
        this.validatorDeleteStudentGroupRequest = validatorDeleteStudentGroupRequest;
        this.validatorEditStudentGroupRequest = validatorEditStudentGroupRequest;
        this.validatorGetStudentGroupByIdRequest = validatorGetStudentGroupByIdRequest;
    }

    public ResponseEntity<?> getStudentGroups(GetStudentGroupsRequest request) {
        ResponseEntity<?> result = null;
        List<String> errors = validatorGetStudentGroupsRequest.validate(request);
        if (errors.isEmpty()) {
            List<StudentGroup> studentGroups = repository.getStudentGroup();

            List<StudentGroupView> studentGroupsView = studentGroups.stream()
                    .filter(s -> request.getNameGroup() == null ||
                            s.getNameGroup().toLowerCase()
                                    .contains(request.getNameGroup().toLowerCase())
                    )
                    .map(s -> new StudentGroupView(s.getId(), s.getNameGroup()))
                    .toList();

            result = new ResponseEntity<>(new GetStudentGroupsResponse(studentGroupsView), 200);
        } else
            result = new ResponseEntity<>(errors, 400);

        return result;
    }

    public ResponseEntity<?> addGroup(AddStudentGroupRequest request) {
        ResponseEntity<?> result = null;
        List<String> errors = validatorAddStudentGroupRequest.validate(request);
        if (errors.isEmpty()) {
            List<StudentGroup> allGroups = repository.getStudentGroup();
            boolean isDuplicate = allGroups.stream()
                    .anyMatch(s -> Objects.equals(s.getNameGroup(), request.getNameGroup()));

            if (isDuplicate) {
                errors.add("Groups with " + request.getNameGroup() + " is exist!");
                result = new ResponseEntity<>(errors, 400);
            } else {
                StudentGroup model = new StudentGroup(null, request.getNameGroup());
                Long modelId = repository.addStudentGroup(model);

                result = new ResponseEntity<>(new AddStudentGroupResponse(modelId, model.getNameGroup()), 200);
            }
        } else
            result = new ResponseEntity<>(errors, 400);

        return result;
    }

    public ResponseEntity<?> deleteStudentGroup(DeleteStudentGroupRequest request) {
        ResponseEntity<?> result = null;
        List<String> errors = validatorDeleteStudentGroupRequest.validate(request);

        if (errors.isEmpty()) {
            StudentGroup studentGroupById = repository.getStudentGroupById(request.getId());
            if (studentGroupById == null) {
                errors.add("Student group with this id:" + request.getId() + " not found!");
                result = new ResponseEntity<>(errors, 404);
            } else {
                List<Student> allStudents = repositoryStudents.getAllStudent();
                boolean existStudentInGroup = allStudents.stream()
                        .anyMatch(s -> Objects.equals(s.getGroup().getId(), request.getId()));

                if (existStudentInGroup) {
                    errors.add("Student exist in this group!");
                    result = new ResponseEntity<>(errors, 400);
                } else {
                    repository.deleteStudentGroup(request.getId());

                    result = new ResponseEntity<>(new DeleteStudentGroupResponse("Deleted successfully"), 200);
                }
            }
        } else {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }

    public ResponseEntity<?> editStudentGroup(EditStudentGroupRequest request) {
        ResponseEntity<?> result = null;
        List<String> errors = validatorEditStudentGroupRequest.validate(request);

        if (errors.isEmpty()) {
            StudentGroup studentGroupById = repository.getStudentGroupById(request.getId());
            if (studentGroupById == null) {
                errors.add("Student group with this id:" + request.getId() + " not found!");
                result = new ResponseEntity<>(errors, 404);
            } else {
                StudentGroup editedStudentGroup = new StudentGroup(request.getId(), request.getNewNameStudentGroup());
                List<StudentGroup> allGroups = repository.getStudentGroup();
                boolean isDuplicate = allGroups.stream()
                        .anyMatch(s -> Objects.equals(request.getNewNameStudentGroup(), s.getNameGroup()) && !Objects.equals(request.getId(), s.getId()));
                if (isDuplicate) {
                    errors.add("Groups with " + request.getNewNameStudentGroup() + " is exist!");
                    result = new ResponseEntity<>(errors, 400);
                } else {
                    repository.editStudentGroup(editedStudentGroup);

                    result = new ResponseEntity<>(new EditStudentGroupResponse(editedStudentGroup.getId(), editedStudentGroup.getNameGroup()), 200);
                }
            }
        } else {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }

    public ResponseEntity<?> getStudentGroupById(GetStudentGroupByIdRequest request) {
        ResponseEntity<?> result = null;
        List<String> errors = validatorGetStudentGroupByIdRequest.validate(request);

        if (errors.isEmpty()) {
            StudentGroup studentGroupById = repository.getStudentGroupById(request.getId());
            if (studentGroupById == null) {
                errors.add("Student group with this id:" + request.getId() + " not found!");
                result = new ResponseEntity<>(errors, 404);
            } else {

                result = new ResponseEntity<>(new GetStudentGroupByIdResponse(studentGroupById.getId(), studentGroupById.getNameGroup()), 200);
            }
        } else {
            result = new ResponseEntity<>(errors, 400);
        }
        return result;
    }
}