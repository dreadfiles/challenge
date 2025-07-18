package org.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConverterListToMap {

    public static void main(String[] args) {
        System.out.println("Start");

        List<Long> listLong = List.of(1L, 2L, 3L, 4L, 3L, 2L, 1L, 5L, 1L);
        Map<Long, Long> mapLongFromList = listLong.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("mapLongFromList = " + mapLongFromList);

        List<String> listString = List.of("A", "B", "C", "D", "C", "B", "A", "E", "A");
        Map<String, Long> mapStringFromList = listString.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("mapStringFromList = " + mapStringFromList);

        Map<String, Long> mapStringLongEntry = Map.ofEntries(Map.entry("A", 2L), Map.entry("B", 3L));
        Map<String, Long> mapStringLongOf = Map.of("A", 2L, "B", 3L);
        Map<String, Long> mapStringLongPut = new HashMap<>();
        mapStringLongPut.put("A", 2L);
        mapStringLongPut.put("B", 3L);

        List<String> listFromMapEntry = new ArrayList<>(mapStringLongEntry.keySet());
        //List<String> listFromMapEntry = mapStringLongEntry.keySet().stream().collect(Collectors.toList());
        System.out.println("listFromMapEntry = " + listFromMapEntry);

        List<Long> listFromMapOf = mapStringLongOf.values().stream().collect(Collectors.toList());
        System.out.println("listFromMapOf = " + listFromMapOf);

        List<String> listFromMapPut = mapStringLongPut.entrySet().stream().map(c -> c.getKey() + "-" + c.getValue()).collect(Collectors.toList());
        System.out.println("listFromMapPut = " + listFromMapPut);

        System.out.println("End");
    }
}
