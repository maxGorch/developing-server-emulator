package com.omsu.gorch825.Validators.Student;

import com.omsu.gorch825.IRequestValidator;
import com.omsu.gorch825.Request.Student.AddStudentRequest;
import com.omsu.gorch825.Validators.IdValidator;
import com.omsu.gorch825.Validators.StatusValidator;
import com.omsu.gorch825.Validators.StringValidator;

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

        String idStudentValidator = IdValidator.idIsCorrect(
                request.getIdStudentGroup(),"Student ID"
        );
        if (idStudentValidator!=null)
            except.add(idStudentValidator);

        String statusIdValidator = StatusValidator.statusIsCorrect(
                request.getStatus(),"Student status"
        );
        if (statusIdValidator!=null)
            except.add(statusIdValidator);

        return except;
    }

}
