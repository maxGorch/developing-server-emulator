package com.omsu.gorch825.validation.StudentGroup;


import com.omsu.gorch825.dto.Request.StudentGroup.DeleteStudentGroupRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentGroupRequestValidator implements IRequestValidator<DeleteStudentGroupRequest> {
    @Override
    public List<String> validate(DeleteStudentGroupRequest request) {
        List<String> except = new ArrayList<>();

        String resultValidator = IdValidator.idIsCorrect(
                request.getId(), "StudentGroup ID"
        );
        if(resultValidator != null)
        {
            except.add(resultValidator);
        }
        return except;
    }
}