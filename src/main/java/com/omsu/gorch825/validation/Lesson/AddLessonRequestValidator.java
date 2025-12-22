package com.omsu.gorch825.validation.Lesson;

import com.omsu.gorch825.dto.Request.Lesson.AddLessonRequest;
import com.omsu.gorch825.validation.*;
import java.util.*;

public class AddLessonRequestValidator implements IRequestValidator<AddLessonRequest> {
    @Override
    public List<String> validate(AddLessonRequest request) {
        List<String> except = new ArrayList<>();

        String dateValidator = DateValidator.dateIsCorrect(request.getDate(), "Lesson Date");
        if (dateValidator != null) except.add(dateValidator);

        String pairValidator = PairNumberValidator.pairIsCorrect(request.getPairNumber(), "Pair Number");
        if (pairValidator != null) except.add(pairValidator);

        String teacherIdValidator = IdValidator.idIsCorrect(request.getTeacherId(), "Teacher ID");
        if (teacherIdValidator != null) except.add(teacherIdValidator);

        String groupIdValidator = IdValidator.idIsCorrect(request.getGroupId(), "Group ID");
        if (groupIdValidator != null) except.add(groupIdValidator);

        String subjectIdValidator = IdValidator.idIsCorrect(request.getSubjectId(), "Subject ID");
        if (subjectIdValidator != null) except.add(subjectIdValidator);

        return except;
    }
}