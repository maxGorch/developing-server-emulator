package com.omsu.gorch825.validation;

public class DateValidator {
    public static String dateIsCorrect(String date, String fieldName) {
        // Регулярное выражение для формата ДД.ММ.ГГГГ
        String regex = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)\\d\\d$";

        if (date == null || !date.matches(regex)) {
            return fieldName + " must be in format DD.MM.YYYY (Russian format)";
        }
        return null;
    }
}