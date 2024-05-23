package org.lesson;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter {

    public static void main(String[] args) {
        System.out.println("Start");

        /* Collections reverseOrder solo funciona con objetos, por eso Integer y no int */
        Integer[] intArray = {1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 5};
        char[] charArray = {'a', 'b', 'c', 'b', 'a', 'b', 'd'};
        List<Long> listLong = new java.util.ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L, 4L, 3L, 2L, 1L, 2L, 5L));
        List<String> listString = new java.util.ArrayList<>(List.of("a", "b", "c", "b", "a", "b", "e"));

        Arrays.sort(intArray, Collections.reverseOrder());
        System.out.println("intArray = " + Arrays.toString(intArray));

        Arrays.sort(charArray);
        System.out.println("charArray = " + Arrays.toString(charArray));

        Collections.sort(listLong);
        System.out.println("listLong = " + listLong);

        listString.sort(Collections.reverseOrder());
        System.out.println("listString = " + listString);

        TreeMap<Long, Long> mapLong = new TreeMap<>();
        mapLong.put(2L, 7L);
        mapLong.put(1L, 3L);
        mapLong.put(3L, 1L);
        System.out.println("mapLong = " + mapLong);

        mapLong.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(
                System.out::println
        );

        Map<Long, Long> sortedMap = mapLong.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap::new));
        System.out.println("sortedMap = " + sortedMap);

        TreeMap<Long, Long> treeMapLong = new TreeMap<>(Comparator.reverseOrder());
        treeMapLong.putAll(mapLong);
        System.out.println("treeMapLong = " + treeMapLong);

        System.out.println("End");
    }
}
