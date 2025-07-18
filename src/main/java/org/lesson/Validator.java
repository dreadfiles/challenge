package org.lesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Validator {

    public static void main(String[] args) {
        System.out.println("Start");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        List<String> filterString = listString.stream().filter(x -> x.length() >= 3).collect(Collectors.toList());
        System.out.println("filterString = " + filterString);

        Map<Long, String> mapLongString = Map.of(1L, "HELLO", 2L, "HI", 3L, "OMG", 4L, "OH");
        Map<Long, String> mapFilteredValue = mapLongString.entrySet().stream().filter(x -> x.getValue().length() >= 3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, HashMap::new));
        System.out.println("mapFilteredValue = " + mapFilteredValue);
        Map<Long, String> mapFilteredKey = mapLongString.entrySet().stream().filter(x -> x.getKey() > 2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, HashMap::new));
        System.out.println("mapFilteredKey = " + mapFilteredKey);

        System.out.println("End");
    }
}
