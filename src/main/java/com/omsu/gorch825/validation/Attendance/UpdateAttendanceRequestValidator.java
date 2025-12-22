package com.omsu.gorch825.validation.Attendance;

import com.omsu.gorch825.dto.Request.Attendance.UpdateAttendanceRequest;
import com.omsu.gorch825.validation.IRequestValidator;
import com.omsu.gorch825.validation.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class UpdateAttendanceRequestValidator implements IRequestValidator<UpdateAttendanceRequest> {
    @Override
    public List<String> validate(UpdateAttendanceRequest request) {
        List<String> except = new ArrayList<>();

        // 1. Валидация ID занятия
        String lessonIdValidator = IdValidator.idIsCorrect(
                request.getLessonId(), "Lesson ID"
        );
        if (lessonIdValidator != null) {
            except.add(lessonIdValidator);
        }

        // 2. Валидация списка студентов
        if (request.getStudentIds() == null) {
            except.add("Student IDs list cannot be null");
        } else {
            // Проверяем каждый ID студента в списке
            for (int i = 0; i < request.getStudentIds().size(); i++) {
                Long studentId = request.getStudentIds().get(i);
                String studentIdValidator = IdValidator.idIsCorrect(
                        studentId, "Student ID at index " + i
                );
                if (studentIdValidator != null) {
                    except.add(studentIdValidator);
                }
            }
        }

        return except;
    }
}