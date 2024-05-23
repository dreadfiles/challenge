package org.lesson;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConverterArrayToSetMap {

    public static void main(String args[]) {
        System.out.println("Start");

        int[] integerArrayToSet = {1, 2, 3, 4, 3, 2, 1};
        Set<Integer> setInteger = Arrays.stream(integerArrayToSet).boxed().collect(Collectors.toSet());
        System.out.println("array int to set integer no duplicates - setInteger = " + setInteger);

        String wordSet = "abcedfdecba";
        Set<String> setString = Arrays.stream(wordSet.split("")).collect(Collectors.toSet());
        System.out.println("String to set string no duplicates - setString = " + setString);

        int[] integerArrayToMap = {1, 2, 3, 4, 3, 2, 1, 5};
        Map<Integer, Long> mapInteger = Arrays.stream(integerArrayToMap).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("array int to map counting duplicates groupingby - mapInteger = " + mapInteger);

        String wordMap = "abcdeabcdexyzab";
        Map<String, Long> mapString = Arrays.stream(wordMap.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("String to map string, long counting duplicates - mapString = " + mapString);

        System.out.println("End");
    }

}
