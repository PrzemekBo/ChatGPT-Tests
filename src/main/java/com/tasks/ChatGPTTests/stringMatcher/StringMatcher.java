package com.tasks.ChatGPTTests.stringMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringMatcher {

    public static List<String> findDollarStrings(String input) {
        List<String> matches = new ArrayList<>();
        String pattern = "\\$\\$[^\\$]+\\$\\$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        int start = 0;
        while (matcher.find(start)) {
            String match = matcher.group();
            matches.add(match);
            start = matcher.end();
        }
        return matches;
    }
}