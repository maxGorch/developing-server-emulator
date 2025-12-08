package com.omsu.gorch825.Application.validator.StudentGroup;

import com.omsu.gorch825.Application.validator.IRequestValidator;
import com.omsu.gorch825.Domain.models.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.Application.validator.StringValidator;

import java.util.*;

public class AddStudentGroupRequestValidator implements IRequestValidator<AddStudentGroupRequest> {
    @Override
    public List<String> validate(AddStudentGroupRequest request) {
        List<String> except = new ArrayList<>();

        String resultValidator = StringValidator.stringIsCorrect(
                request.getNameGroup(), "getNameGroup"
        );

       if(resultValidator != null)
       {
           except.add(resultValidator);
       }
       return except;
    }
}
