package com.omsu.gorch825.Validators.Student;

import com.omsu.gorch825.IRequestValidator;
import com.omsu.gorch825.Request.Student.AddStudentRequest;
import com.omsu.gorch825.Validators.StringValidator;

import java.util.*;

public class AddStudentRequestValidator implements IRequestValidator<AddStudentRequest> {
    @Override
    public List<String> validate(AddStudentRequest request)
    {
        List<String> except = new ArrayList<>();

        String resultValidator = StringValidator.stringIsCorrect(
                request.getFirstName(),"firstName"
        );

        if(resultValidator != null)
        {
            except.add(resultValidator);
        }
        return except;
    }

}
