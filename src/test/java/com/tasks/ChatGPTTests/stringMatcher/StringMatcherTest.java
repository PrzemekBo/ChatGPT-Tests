package com.tasks.ChatGPTTests.stringMatcher;

import com.tasks.ChatGPTTests.stringMatcher.StringMatcher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

public class StringMatcherTest {

    @Test
    public void testEmptyString() {
        String input = "";
        List<String> expected = new ArrayList<String>();
        List<String> result = StringMatcher.findDollarStrings(input);
        assertEquals(expected, result);
    }

    @Test
    public void testNoMatches() {
        String input = "This string has no matches";
        List<String> expected = new ArrayList<String>();
        List<String> result = StringMatcher.findDollarStrings(input);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleMatch() {
        String input = "This string has a $$match$$";
        List<String> expected = new ArrayList<String>();
        expected.add("$$match$$");
        List<String> result = StringMatcher.findDollarStrings(input);
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleMatches() {
        String input = "This string has $$two$$ matches: $$match1$$ and $$match2$$";
        List<String> expected = new ArrayList<String>();
        expected.add("$$two$$");
        expected.add("$$match1$$");
        expected.add("$$match2$$");
        List<String> result = StringMatcher.findDollarStrings(input);
        assertEquals(expected, result);
    }

    @Test
    public void testNestedMatches() {
        String input = "This string has a nested $$match with a $$nested$$ match$$";
        List<String> expected = new ArrayList<String>();
        expected.add("$$match with a $$nested$$ match$$");
        expected.add("$$nested$$");
        List<String> result = StringMatcher.findDollarStrings(input);
        assertEquals(expected, result);
    }
}
