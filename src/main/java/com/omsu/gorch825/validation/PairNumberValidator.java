package com.omsu.gorch825.validation;

public class PairNumberValidator {
    public static String pairIsCorrect(int pairNumber, String fieldName) {
        if (pairNumber < 1 || pairNumber > 8) {
            return fieldName + " must be between 1 and 8";
        }
        return null;
    }
}