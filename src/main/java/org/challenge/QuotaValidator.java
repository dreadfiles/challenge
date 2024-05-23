package org.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

/*
    Given a list of input stings, return a map with the boolean result validating if each string closes the symbols '{', '[', '(' correctly
 */
public class QuotaValidator {

    public static Map<String, Boolean> validateList(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(value -> value, QuotaValidator::isValidString));
    }

    public static boolean isValidString(String input) {
        String openers = "{[(";

        Map<Character, Character> closers = Map.ofEntries(
                entry('}', '{'),
                entry(']', '['),
                entry(')', '(')
        );

        List<Character> addedOpeners = new ArrayList<>();
        char[] inputCharArray = input.toCharArray();

        for (char item : inputCharArray) {
            if (openers.contains(String.valueOf(item))) {
                addedOpeners.add(item);
            } else if (closers.containsKey(item)) {
                if (addedOpeners.isEmpty()) {
                    return false;
                }
                if (addedOpeners.get(addedOpeners.size() - 1) != closers.get(item)) {
                    return false;
                }
                addedOpeners.remove(addedOpeners.size() - 1);
            }
        }

        return addedOpeners.isEmpty();
    }
}
