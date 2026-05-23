package com.omsu.gorch825.validation;

import static com.omsu.gorch825.models.Enums.StudentStatus.ACTIVE;
import static com.omsu.gorch825.models.Enums.StudentStatus.EXPELLED;
import static com.omsu.gorch825.models.Enums.StudentStatus.SABBATICAL;

import com.omsu.gorch825.models.Enums.StudentStatus;

public class StatusValidator {
    public static String statusIsCorrect(StudentStatus status, String fieldName) {
        String except;

        if (status != ACTIVE && status != SABBATICAL && status != EXPELLED) {
            except = fieldName + " Id is null or not the ACTIVE/SABBATICAL/EXPELLED";
        } else
            return null;
        return except;
    }
}
