package com.omsu.gorch825.validation.Lesson;

import com.omsu.gorch825.dto.Request.Lesson.DeleteLessonRequest;
import com.omsu.gorch825.validation.*;
import java.util.*;

public class DeleteLessonRequestValidator implements IRequestValidator<DeleteLessonRequest> {
    @Override
    public List<String> validate(DeleteLessonRequest request) {
        List<String> except = new ArrayList<>();

        String idValidator = IdValidator.idIsCorrect(request.getId(), "Lesson ID");
        if (idValidator != null) except.add(idValidator);

        return except;
    }
}