package org.lesson;

import java.util.List;

public class StringFunctions {

    public static void main(String[] args) {
        System.out.println("Start");

        List<String> stringListOf = List.of("Hello".split(""));
        String stringJoin = String.join("-", stringListOf);
        System.out.println("stringJoin = " + stringJoin);

        System.out.println("End");
    }

}
