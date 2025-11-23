package com.omsu.gorch825.Validators;

public class StringValidator {

    public static String stringIsCorrect(String value, String fieldName) {
        String except;
        if (value == null || value.isEmpty()) {
            except = fieldName + " is empty or null!";
        } else {
            return null;
        }
        return except;
    }

}
