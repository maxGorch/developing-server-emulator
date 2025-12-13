package com.omsu.gorch825.controller;

import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.repository.IGroupStudentRepositories;
import com.omsu.gorch825.validation.StudentGroup.AddStudentGroupRequestValidator;
import com.omsu.gorch825.models.ResponseEntity;
import com.omsu.gorch825.models.StudentGroup.StudentGroup;
import com.omsu.gorch825.dto.Response.StudentGroup.StudentGroupView;

import java.util.List;

public class StudentGroupController
{
    private final IGroupStudentRepositories repository;
    private final AddStudentGroupRequestValidator validator;

    public StudentGroupController(IGroupStudentRepositories repository,
                                  AddStudentGroupRequestValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }
    public ResponseEntity<?> addGroup(AddStudentGroupRequest request) {
        ResponseEntity<?> result = null;
        // 1. Валидация
        List<String> errors = validator.validate(request);
        // 2. Сохранение и возврат (статус 200)
        if (errors.isEmpty())
        {
            StudentGroup model = new StudentGroup(
                    null,
                    request.getNameGroup()
            );

            Long modelId = repository.addStudentGroup(model);

            StudentGroupView view = new StudentGroupView(
                    modelId,
                    model.getNameGroup()
            );

            result = new ResponseEntity<>(view,200);
        }
        // 3. Проверка ошибок (статус 400)
        else
            result = new ResponseEntity<>(errors,400);

        return result;
    }
}
