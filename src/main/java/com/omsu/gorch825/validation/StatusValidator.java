package com.omsu.gorch825.validation;


import com.omsu.gorch825.models.StudentStatus;

import static com.omsu.gorch825.models.StudentStatus.EXPELLED;
import static com.omsu.gorch825.models.StudentStatus.SABBATICAL;
import static com.omsu.gorch825.models.StudentStatus.ACTIVE;
public class StatusValidator {
    public static String statusIsCorrect(StudentStatus status, String fieldName)
    {
        String except;

        if (status != ACTIVE && status != SABBATICAL && status != EXPELLED) {
            except = fieldName+ " Id is null or not the ACTIVE/SABBATICAL/EXPELLED";
        } else return null;
        return except;
    }
}
