package com.yokall.daytwo;

import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public int validatePasswordsPartOne(List<String> passwordConfigs) {
        int validPasswordCount = 0;

        for (String passwordConfig : passwordConfigs) {
            PasswordRule passwordRule = getPasswordRule(passwordConfig);

            int count = 0;

            for (int i = 0; i < passwordRule.getPassword().length(); i++) {
                char c = passwordRule.getPassword().charAt(i);

                if (c == passwordRule.getSignificantLetter()) {
                    count++;
                }
            }

            if (count >= passwordRule.getLowerBound() && count <= passwordRule.getUpperBound()) {
                validPasswordCount++;
            }
        }

        return validPasswordCount;
    }

    private PasswordRule getPasswordRule(String passwordConfig) {
        Pattern regex = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

        Matcher matcher = regex.matcher(passwordConfig);

        PasswordRule passwordRule = new PasswordRule();

        if (matcher.find()) {
            passwordRule.setLowerBound(Integer.parseInt(matcher.group(1)));
            passwordRule.setUpperBound(Integer.parseInt(matcher.group(2)));

            passwordRule.setSignificantLetter(matcher.group(3).charAt(0));

            passwordRule.setPassword(matcher.group(4));
        }

        return passwordRule;
    }

    public int validatePasswordsPartTwo(List<String> passwordConfigs) {
        int validPasswordCount = 0;

        for (String passwordConfig : passwordConfigs) {
            PasswordRule passwordRule = getPasswordRule(passwordConfig);

            if (
                    (
                            passwordRule.getPassword().charAt(passwordRule.getLowerBound() - 1) == passwordRule.getSignificantLetter()
                            || passwordRule.getPassword().charAt(passwordRule.getUpperBound() - 1) == passwordRule.getSignificantLetter()
                    )
                            &&
                            passwordRule.getPassword().charAt(passwordRule.getLowerBound() - 1) != passwordRule.getPassword().charAt(passwordRule.getUpperBound() - 1)
            ) {
                validPasswordCount++;
            }

//            int count = 0;
//
//            for (int i = 0; i < passwordRule.getPassword().length(); i++) {
//                char c = passwordRule.getPassword().charAt(i);
//
//                if (c == passwordRule.getSignificantLetter()) {
//                    count++;
//                }
//            }
//
//            if (count >= passwordRule.getLowerBound() && count <= passwordRule.getUpperBound()) {
//                validPasswordCount++;
//            }
        }

        return validPasswordCount;
    }
}
