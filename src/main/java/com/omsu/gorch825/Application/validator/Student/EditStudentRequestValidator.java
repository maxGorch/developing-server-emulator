package com.omsu.gorch825.Application.validator.Student;

import com.omsu.gorch825.Application.validator.IRequestValidator;
import com.omsu.gorch825.Application.validator.IdValidator;
import com.omsu.gorch825.Application.validator.StatusValidator;
import com.omsu.gorch825.Application.validator.StringValidator;
import com.omsu.gorch825.Domain.models.Student.EditStudentRequest;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator implements IRequestValidator<EditStudentRequest> {
    @Override
    public List<String> validate(EditStudentRequest request) {
        List<String> except = new ArrayList<>();

        String firstNameStudentValidator = StringValidator.stringIsCorrect(
                request.getFirstName(),"FirstName"
        );
        if(firstNameStudentValidator != null)
            except.add(firstNameStudentValidator);

        String middleNameStudentValidator = StringValidator.stringIsCorrect(
                request.getMiddleName(),"MiddleName"
        );
        if( middleNameStudentValidator != null)
            except.add(middleNameStudentValidator);

        String lastNameStudentValidator = StringValidator.stringIsCorrect(
                request.getLastName(),"LastName"
        );
        if(lastNameStudentValidator != null)
            except.add(lastNameStudentValidator);

        String idStudentValidator = IdValidator.idIsCorrect(
                request.getId(),"Student ID"
        );
        if (idStudentValidator!=null)
            except.add(idStudentValidator);

        String idStudentGroupValidator = IdValidator.idIsCorrect(
                request.getIdStudentGroup(),"Student Group ID"
        );
        if (idStudentGroupValidator!=null)
            except.add(idStudentGroupValidator);

        String statusIdValidator = StatusValidator.statusIsCorrect(
                request.getStatus(),"Student status"
        );
        if (statusIdValidator!=null)
            except.add(statusIdValidator);

        return except;
    }
}
