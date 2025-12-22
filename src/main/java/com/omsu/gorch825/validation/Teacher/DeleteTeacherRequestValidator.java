package com.omsu.gorch825.validation.Teacher;

import com.omsu.gorch825.dto.Request.Teacher.DeleteTeacherRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;
import java.util.ArrayList;
import java.util.List;

public class DeleteTeacherRequestValidator implements IRequestValidator<DeleteTeacherRequest> {
    @Override
    public List<String> validate(DeleteTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        String idError = IdValidator.idIsCorrect(request.getId(), "Teacher ID");
        if (idError != null) errors.add(idError);

        return errors;
    }
}