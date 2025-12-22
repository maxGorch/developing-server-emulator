package com.omsu.gorch825.validation.Lesson;

import com.omsu.gorch825.dto.Request.Lesson.GetLessonByIdRequest;
import com.omsu.gorch825.validation.*;
import java.util.*;

public class GetLessonByIdRequestValidator implements IRequestValidator<GetLessonByIdRequest> {
    @Override
    public List<String> validate(GetLessonByIdRequest request) {
        List<String> except = new ArrayList<>();

        String idValidator = IdValidator.idIsCorrect(request.getId(), "Lesson ID");
        if (idValidator != null) except.add(idValidator);

        return except;
    }
}