package org.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Converter: primitive arrays to Lists */
public class ConverterArrayToList {

    public static void main(String args[]) {
        System.out.println("Start");

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);
        System.out.println("int array as list: " + integerList1);

        int[] integerArray2 = {1, 2, 3, 4, 3, 2, 1};
        List<Integer> integerList2 = Arrays.stream(integerArray2).boxed().collect(Collectors.toList());
        System.out.println("int array stream boxed collect: " + integerList2);

        long[] longArray = {1, 2, 3, 4, 3, 2, 1};
        List<Long> longList = Arrays.stream(longArray).boxed().collect(Collectors.toList());
        System.out.println("long array stream boxed collect: " + longList);

        String word = "word";
        char[] charArray = word.toCharArray();
        System.out.print("char array toCharArray from string: ");
        System.out.println(charArray);
        List<Character> charList = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("char list from string map collect: " + charList);
        List<Character> charList2 = String.valueOf(charArray).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("char list from char array map collect: " + charList2);
        List<String> stringList = Arrays.stream(word.split("")).collect(Collectors.toList());
        System.out.println("string list from string split collect: " + stringList);
        List<String> stringListOf = List.of(word.split(""));
        System.out.println("stringListOf = " + stringListOf);

        String stringJoin = String.join("-", stringList);
        System.out.println("string concat from string list join - stringJoin = " + stringJoin);

        System.out.println("End");
    }

}
