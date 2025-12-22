package com.omsu.gorch825.validation.StudentGroup;

import com.omsu.gorch825.dto.Request.StudentGroup.GetStudentGroupsRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupsRequestValidator implements IRequestValidator<GetStudentGroupsRequest> {
    @Override
    public List<String> validate(GetStudentGroupsRequest request) {
        List<String> except = new ArrayList<>();

        String newNameStudentGroupValidator = StringValidator.stringIsCorrect(
                request.getNameGroup(), "StudentGroup Name"
        );
        if(newNameStudentGroupValidator != null)
        {
            except.add(newNameStudentGroupValidator);
        }
        return except;
    }
}
