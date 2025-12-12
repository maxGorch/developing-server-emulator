package com.omsu.gorch825.Application.validator.Student;

import com.omsu.gorch825.Application.validator.IRequestValidator;
import com.omsu.gorch825.Application.validator.IdValidator;
import com.omsu.gorch825.Domain.models.Student.GetStudentsByGroupRequest;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupRequestValidator implements IRequestValidator<GetStudentsByGroupRequest>
{
    @Override
    public List<String> validate(GetStudentsByGroupRequest request) {

        List<String> except = new ArrayList<>();

        String idStudentGroupValidator = IdValidator.idIsCorrect(
                request.getIdStudentGroup(),"Student Group ID"
        );
        if (idStudentGroupValidator!=null)
            except.add(idStudentGroupValidator);

        return except;
    }
}
