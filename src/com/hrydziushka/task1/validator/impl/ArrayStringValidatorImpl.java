package com.hrydziushka.task1.validator.impl;

import com.hrydziushka.task1.validator.ArrayStringValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayStringValidatorImpl implements ArrayStringValidator {
    private static final String STRING_PATTERN_REGEX = "^((0|((-|\\+)?[1-9]\\d*));)+$";

    @Override
    public boolean isValidate(String str) {
        Pattern pattern = Pattern.compile(STRING_PATTERN_REGEX);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
