package org.challenge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Palindrome {

    public static Map<String, Boolean> validateListReverse(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(value -> value, Palindrome::isPalindromeReverse));
    }

    public static Map<String, Boolean> validateListFor(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(value -> value, Palindrome::isPalindromeFor));
    }

    public static boolean isPalindromeReverse(String input) {
        String noSpacesInput = input.replace(" ", "");
        String reverseInput = new StringBuilder(noSpacesInput).reverse().toString();
        return noSpacesInput.equalsIgnoreCase(reverseInput);
    }

    public static boolean isPalindromeFor(String input) {
        String noSpacesLowerCaseInput = input.replace(" ", "").toLowerCase();
        int inputLength = noSpacesLowerCaseInput.length() - 1;
        for (int i = 0, j = inputLength; i < inputLength; i++, j--) {
            if (noSpacesLowerCaseInput.charAt(i) != noSpacesLowerCaseInput.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
