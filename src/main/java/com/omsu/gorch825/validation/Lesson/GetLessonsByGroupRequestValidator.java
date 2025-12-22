package com.omsu.gorch825.validation.Lesson;

import com.omsu.gorch825.dto.Request.Lesson.GetLessonsByGroupRequest;
import com.omsu.gorch825.validation.*;
import java.util.*;

public class GetLessonsByGroupRequestValidator implements IRequestValidator<GetLessonsByGroupRequest> {
    @Override
    public List<String> validate(GetLessonsByGroupRequest request) {
        List<String> except = new ArrayList<>();

        String startDateValidator = DateValidator.dateIsCorrect(request.getStartDate(), "Start Date");
        if (startDateValidator != null) except.add(startDateValidator);

        String endDateValidator = DateValidator.dateIsCorrect(request.getEndDate(), "End Date");
        if (endDateValidator != null) except.add(endDateValidator);

        String groupIdValidator = IdValidator.idIsCorrect(request.getGroupId(), "Group ID");
        if (groupIdValidator != null) except.add(groupIdValidator);

        return except;
    }
}