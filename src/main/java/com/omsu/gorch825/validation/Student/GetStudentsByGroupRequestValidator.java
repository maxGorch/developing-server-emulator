package com.omsu.gorch825.validation.Student;

import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;
import com.omsu.gorch825.dto.Request.Student.GetStudentsByGroupRequest;

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
