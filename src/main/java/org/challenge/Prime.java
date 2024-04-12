package org.challenge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Java program to determine whether a number is prime */
public class Prime {

    public static Map<Integer, Boolean> validateList(List<Integer> inputList) {
        return inputList.stream().collect(Collectors.toMap(value -> value, Prime::isPrime));
    }

    public static boolean isPrime(Integer input) {
        int counter = 0;

        for (int index = 1; index <= input && counter <= Constant.PRIME_COUNTER; index++) {
            if ((input % index) == 0) {
                counter++;
            }
        }

        return (counter == Constant.PRIME_COUNTER);
    }
}
