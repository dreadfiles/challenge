package org.lesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Modifier {

    public static void main(String[] args) {
        System.out.println("Start");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        List<String> listModified = listString.stream().map(x -> x.concat("***")).collect(Collectors.toList());
        System.out.println("listModified = " + listModified);

        Map<Long, String> mapLongString = Map.of(2L, "HELLO", 4L, "HI", 3L, "OMG", 1L, "OH");
        Map<Long, String> mapModifiedValue = mapLongString.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().concat("###")));
        System.out.println("mapModifiedValue = " + mapModifiedValue);

        List<String> listStringMap = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        Map<String, Long> mapListModified = listStringMap.stream().filter(x -> x.length() > 2).map(x -> x.concat("***")).collect(Collectors.toMap(Function.identity(), x -> Long.valueOf(x.length())));
        System.out.println("mapListModified = " + mapListModified);

        Map<Long, String> mapToListString = Map.of(2L, "HELLO", 4L, "HI", 3L, "OMG", 1L, "OH");
        List<String> listMapModified = mapToListString.entrySet().stream().filter(x -> x.getValue().length() > 2).map(x -> x.getKey() + "-" + x.getValue()).collect(Collectors.toList());
        System.out.println("listMapModified = " + listMapModified);

        System.out.println("End");
    }

}
