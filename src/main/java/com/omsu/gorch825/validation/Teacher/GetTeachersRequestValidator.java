package com.omsu.gorch825.validation.Teacher;

import com.omsu.gorch825.dto.Request.Teacher.GetTeachersRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetTeachersRequestValidator implements IRequestValidator<GetTeachersRequest> {
    @Override
    public List<String> validate(GetTeachersRequest request) {
        List<String> errors = new ArrayList<>();

        String idGroupError = IdValidator.idIsCorrect(
                request.getIdGroup(), "Group ID"
        );

        if (idGroupError != null) {
            errors.add(idGroupError);
        }

        return errors;
    }
}