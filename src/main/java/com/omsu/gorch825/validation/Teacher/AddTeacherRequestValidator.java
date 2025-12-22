package com.omsu.gorch825.validation.Teacher;

import com.omsu.gorch825.dto.Request.Teacher.AddTeacherRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.StringValidator;
import java.util.ArrayList;
import java.util.List;

public class AddTeacherRequestValidator implements IRequestValidator<AddTeacherRequest> {
    @Override
    public List<String> validate(AddTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        String firstNameError = StringValidator.stringIsCorrect(request.getFirstName(), "FirstName");
        if (firstNameError != null) errors.add(firstNameError);

        String middleNameError = StringValidator.stringIsCorrect(request.getMiddleName(), "MiddleName");
        if (middleNameError != null) errors.add(middleNameError);

        String lastNameError = StringValidator.stringIsCorrect(request.getLastName(), "LastName");
        if (lastNameError != null) errors.add(lastNameError);

        return errors;
    }
}