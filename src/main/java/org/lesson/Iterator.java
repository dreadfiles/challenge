package org.lesson;

import java.util.List;
import java.util.Map;

public class Iterator {

    public static void main(String[] args) {
        System.out.println("Start");

        /* array int for : */
        int[] arrayInteger = {3, 2, 1, 2, 3, 4};
        for (int item : arrayInteger) {
            System.out.println("item = " + item);
        }

        /* array char for : */
        String word = "word";
        char[] arrayChar = word.toCharArray();
        for (char item : arrayChar) {
            System.out.println("item = " + item);
        }

        /* map */
        Map<String, Long> mapStringLong = Map.of("A", 2L, "B", 3L, "C", 1L);
        for (Map.Entry item : mapStringLong.entrySet()) {
            System.out.println("item = " + item.getKey() + "--" + item.getValue());
        }
        mapStringLong.forEach((k, v) -> System.out.println(k + "--" + v));

        List<Long> listLong = List.of(1L, 2L, 5L, 8L);
        for (Long item : listLong) {
            System.out.println("item = " + item);
        }

        listLong.forEach(c -> System.out.println("c = " + c));

        System.out.println("End");
    }
}
