package com.omsu.gorch825.validation.Student;

import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;
import com.omsu.gorch825.dto.Request.Student.DeleteStudentRequest;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentRequestValidator implements IRequestValidator<DeleteStudentRequest> {
    @Override
    public List<String> validate(DeleteStudentRequest request) {
        List<String> except = new ArrayList<>();

        String idStudentValidator = IdValidator.idIsCorrect(
                request.getId(),"Student ID"
        );
        if (idStudentValidator!=null)
            except.add(idStudentValidator);

        return except;
    }
}
