package org.lesson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reducer {

    public static void main(String[] args) {
        System.out.println("Start");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        String result = listString.stream().reduce("HEADER_", (x, y) -> x.concat(y).concat("**"));
        System.out.println("result = " + result);
        String maxStringCollection = Collections.min(listString);
        System.out.println("maxStringCollection = " + maxStringCollection);

        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer intResult = listInteger.stream().min(Integer::compare).orElse(0);
        System.out.println("intResult = " + intResult);
        Integer minCollections = Collections.min(listInteger);
        System.out.println("minCollections = " + minCollections);

        System.out.println("End");
    }

}
