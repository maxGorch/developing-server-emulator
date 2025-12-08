package com.omsu.gorch825.API.controller;

import com.omsu.gorch825.Domain.models.Student.AddStudentRequest;
import com.omsu.gorch825.Domain.repositories.IGroupStudentRepositories;
import com.omsu.gorch825.Domain.repositories.IStudentRepositories;
import com.omsu.gorch825.Application.validator.Student.AddStudentRequestValidator;
import com.omsu.gorch825.API.view.ResponseEntity;
import com.omsu.gorch825.API.view.Student.Student;
import com.omsu.gorch825.API.view.Student.StudentView;
import com.omsu.gorch825.API.view.StudentGroup.StudentGroup;

import java.util.List;

public class StudentController
{
    private final IStudentRepositories repository;
    private final AddStudentRequestValidator validator;
    private final IGroupStudentRepositories studentGroupRepository;

    public StudentController(IStudentRepositories repository, AddStudentRequestValidator validator, IGroupStudentRepositories studentGroupRepository) {
        this.repository = repository;
        this.validator = validator;
        this.studentGroupRepository = studentGroupRepository;
    }
    public ResponseEntity<?> addStudent(AddStudentRequest request)
    {
        ResponseEntity<?> result = null;
        StudentGroup group = studentGroupRepository.getEntityById(request.getIdStudentGroup());
        // 1. Валидация
        List<String> errors = validator.validate(request);
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
}
