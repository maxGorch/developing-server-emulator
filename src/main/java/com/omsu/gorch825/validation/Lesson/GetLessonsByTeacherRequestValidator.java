package com.omsu.gorch825.validation.Lesson;

import com.omsu.gorch825.dto.Request.Lesson.GetLessonsByTeacherRequest;
import com.omsu.gorch825.validation.*;
import java.util.*;

public class GetLessonsByTeacherRequestValidator implements IRequestValidator<GetLessonsByTeacherRequest> {
    @Override
    public List<String> validate(GetLessonsByTeacherRequest request) {
        List<String> except = new ArrayList<>();

        String startDateValidator = DateValidator.dateIsCorrect(request.getStartDate(), "Start Date");
        if (startDateValidator != null) except.add(startDateValidator);

        String endDateValidator = DateValidator.dateIsCorrect(request.getEndDate(), "End Date");
        if (endDateValidator != null) except.add(endDateValidator);

        String teacherIdValidator = IdValidator.idIsCorrect(request.getTeacherId(), "Teacher ID");
        if (teacherIdValidator != null) except.add(teacherIdValidator);

        return except;
    }
}