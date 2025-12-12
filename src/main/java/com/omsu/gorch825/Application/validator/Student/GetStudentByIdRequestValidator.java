package com.omsu.gorch825.Application.validator.Student;

import com.omsu.gorch825.Application.validator.IRequestValidator;
import com.omsu.gorch825.Application.validator.IdValidator;
import com.omsu.gorch825.Domain.models.Student.GetStudentByIdRequest;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IRequestValidator<GetStudentByIdRequest> {
    @Override
    public List<String> validate(GetStudentByIdRequest request) {
        List<String> except = new ArrayList<>();

        String idStudentValidator = IdValidator.idIsCorrect(
                request.getId(),"Student ID"
        );
        if (idStudentValidator!=null)
            except.add(idStudentValidator);

        return except;
    }
}
