package com.home.expenses.utils;

import com.home.expenses.entity.PaymentMode;

import java.util.regex.Pattern;

public class Utils {

    public static boolean emptyString(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean patternMatches(String str, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(str)
                .matches();
    }
}
