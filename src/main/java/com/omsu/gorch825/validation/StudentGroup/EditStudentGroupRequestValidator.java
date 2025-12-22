package com.omsu.gorch825.validation.StudentGroup;

import com.omsu.gorch825.dto.Request.StudentGroup.EditStudentGroupRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;
import com.omsu.gorch825.validation.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator implements IRequestValidator<EditStudentGroupRequest> {
    @Override
    public List<String> validate(EditStudentGroupRequest request) {
        List<String> except = new ArrayList<>();

        String newNameStudentGroupValidator = StringValidator.stringIsCorrect(
                request.getNewNameStudentGroup(), "New StudentGroup Name"
        );
        if(newNameStudentGroupValidator != null)
        {
            except.add(newNameStudentGroupValidator);
        }
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
