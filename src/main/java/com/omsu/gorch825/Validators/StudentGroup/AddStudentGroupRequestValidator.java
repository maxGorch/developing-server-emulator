package com.omsu.gorch825.Validators.StudentGroup;

import com.omsu.gorch825.IRequestValidator;
import com.omsu.gorch825.Request.StudentGroup.AddStudentGroupRequest;
import com.omsu.gorch825.Validators.StringValidator;

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
