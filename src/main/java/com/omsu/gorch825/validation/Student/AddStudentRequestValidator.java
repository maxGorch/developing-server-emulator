package com.omsu.gorch825.validation.Student;

import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.dto.Request.Student.AddStudentRequest;
import com.omsu.gorch825.validation.IdValidator;
import com.omsu.gorch825.validation.StatusValidator;
import com.omsu.gorch825.validation.StringValidator;

import java.util.*;

public class AddStudentRequestValidator implements IRequestValidator<AddStudentRequest> {
    @Override
    public List<String> validate(AddStudentRequest request)
    {
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
