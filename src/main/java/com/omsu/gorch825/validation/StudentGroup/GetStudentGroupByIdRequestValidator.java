package com.omsu.gorch825.validation.StudentGroup;

import com.omsu.gorch825.dto.Request.StudentGroup.GetStudentGroupByIdRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;


import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupByIdRequestValidator implements IRequestValidator<GetStudentGroupByIdRequest> {
    @Override
    public List<String> validate(GetStudentGroupByIdRequest request) {
        List<String> except = new ArrayList<>();

        String idValidator = IdValidator.idIsCorrect(
                request.getId(), "StudentGroup Id"
        );
        if(idValidator != null)
        {
            except.add(idValidator);
        }
        return except;
    }
}
