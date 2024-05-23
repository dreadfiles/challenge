package org.lesson;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teener {

    public static void main(String[] args) {
        System.out.println("Start");

        List<Integer> listString = List.of(100, 200, 300, 400, 500);

        var listInteger = listString.stream().collect(Collectors.teeing(
                Collectors.filtering(x -> x < 300, Collectors.mapping(x -> x * 0.5, Collectors.toList())),
                Collectors.filtering(x -> x > 300, Collectors.mapping(x -> x * 1.5, Collectors.toList())),
                (x, y) -> Stream.concat(x.stream(), y.stream()).toList()
        ));
        System.out.println("listInteger = " + listInteger);

        System.out.println("End");
    }

}
