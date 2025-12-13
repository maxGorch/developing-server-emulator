package com.omsu.gorch825.validation;

public class IdValidator {

    public static String idIsCorrect(Long id, String fieldName) {
        String except;

        if (id == null || id <= 0) {
            except = fieldName+ " Id is null or <= 0";
        } else return null;
        return except;
    }
}
