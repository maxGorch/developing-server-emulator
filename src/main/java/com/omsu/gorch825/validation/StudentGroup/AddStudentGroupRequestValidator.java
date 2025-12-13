package com.omsu.gorch825.validation.StudentGroup;

import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.dto.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.validation.StringValidator;

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
