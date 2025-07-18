package org.lesson;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapper {

    public static void main(String[] args) {
        System.out.println("Start");

        List<Long> listLongMap = List.of(3L, 2L, 1L);
        List<String> listStringMap = List.of("HELLO", "HI", "OMG", "WTF");

        List<String> listResult = listLongMap.stream().flatMap(x -> {
            return listStringMap.stream().map(y -> x + " " + y);
        }).collect(Collectors.toList());
        System.out.println("listResult = " + listResult);

        System.out.println("End");
    }

}
