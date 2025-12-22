package com.omsu.gorch825.validation.Teacher;

import com.omsu.gorch825.dto.Request.Teacher.EditTeacherRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;
import com.omsu.gorch825.validation.StringValidator;
import java.util.ArrayList;
import java.util.List;

public class EditTeacherRequestValidator implements IRequestValidator<EditTeacherRequest> {
    @Override
    public List<String> validate(EditTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        String idError = IdValidator.idIsCorrect(request.getId(), "Teacher ID");
        if (idError != null) errors.add(idError);

        String firstNameError = StringValidator.stringIsCorrect(request.getFirstName(), "FirstName");
        if (firstNameError != null) errors.add(firstNameError);

        String middleNameError = StringValidator.stringIsCorrect(request.getMiddleName(), "MiddleName");
        if (middleNameError != null) errors.add(middleNameError);

        String lastNameError = StringValidator.stringIsCorrect(request.getLastName(), "LastName");
        if (lastNameError != null) errors.add(lastNameError);

        return errors;
    }
}