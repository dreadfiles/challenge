package org.lesson;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        converterArrayToList();
        converterArrayToSetMap();
        converterListToMap();
        flatMapper();
        iterator();
        modifier();
        reducer();
        sorter();
        stringFunctions();
        teenier();
        filter();
    }

    public static void converterArrayToList() {
        System.out.println("Starting converterArrayToList...");

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);
        //this is an immutable list, so the following line will throw an UnsupportedOperationException
        //integerList1.add(Integer.valueOf(6));
        System.out.println("integerList1 = " + integerList1);

        int[] integerArray = {1, 2, 3, 4, 3, 2, 1};
        List<Integer> integerList2 = Arrays.stream(integerArray).boxed().toList();
        System.out.println("integerList2 = " + integerList2);

        long[] longArray = {1, 2, 3, 4, 3, 2, 1};
        List<Long> longList = Arrays.stream(longArray).boxed().toList();
        System.out.println("longList = " + longList);

        String chainsaw = "chainsaw";
        char[] charArray = chainsaw.toCharArray();
        System.out.println("charArray = " + Arrays.toString(charArray));
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();
        List<Character> characterList = chainsaw.chars().mapToObj(c -> (char) c).toList();
        System.out.println("characterList = " + characterList);
        String[] stringArray = chainsaw.split("");
        System.out.println("stringArray = " + Arrays.toString(stringArray));
        List<String> stringList = Arrays.stream(stringArray).toList();
        System.out.println("stringList = " + stringList);

        List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5);
        //This is immutable, so the following line will throw an UnsupportedOperationException
        //listOfIntegers.add(Integer.valueOf(8));
        System.out.println("listOfIntegers = " + listOfIntegers);
        List<String> listOfStrings = List.of("one", "two", "three");
        System.out.println("listOfStrings = " + listOfStrings);

        String joinedString = String.join("-", listOfStrings);
        System.out.println("joinedString = " + joinedString);

        String joinedString2 = String.join(" ", stringList);
        System.out.println("joinedString2 = " + joinedString2);

        String joinedString3 = String.join(" ", characterList.stream().map(String::valueOf).toList());
        System.out.println("joinedString3 = " + joinedString3);

        System.out.println("Ending converterArrayToList...");
    }

    public static void converterArrayToSetMap() {
        System.out.println("Starting converterArrayToSetMap...");

        int[] integerArrayToSet = {4, 3, 2, 1, 1, 2, 3};
        System.out.println("integerArrayToSet = " + Arrays.toString(integerArrayToSet));
        Set<Integer> integerSet = Arrays.stream(integerArrayToSet).boxed().collect(Collectors.toSet());
        System.out.println("integerSet = " + integerSet);
        HashSet<Integer> integerHashSet = Arrays.stream(integerArrayToSet).boxed().collect(Collectors.toCollection(HashSet::new));
        System.out.println("integerHashSet = " + integerHashSet);
        LinkedHashSet<Integer> integerLinkedHashSet = Arrays.stream(integerArrayToSet).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("integerLinkedHashSet = " + integerLinkedHashSet);

        String chainsawSet = "iesjdjwaxeil";
        String[] stringArraySet = chainsawSet.split("");
        System.out.println("stringArraySet = " + Arrays.toString(stringArraySet));
        Set<String> stringSet = Arrays.stream(stringArraySet).collect(Collectors.toSet());
        System.out.println("stringSet = " + stringSet);
        LinkedHashSet<String> stringLinkedHashSet = Arrays.stream(stringArraySet).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("stringLinkedHashSet = " + stringLinkedHashSet);

        int[] integerArrayToMap = {4, 3, 2, 1, 5, 1, 2, 3};
        System.out.println("integerArrayToMap = " + Arrays.toString(integerArrayToMap));
        Map<Integer, Long> mapInteger = Arrays.stream(integerArrayToMap).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("mapInteger = " + mapInteger);

        String stringToMap = "dexyzababcdeabc";
        String[] stringArrayToMap = stringToMap.split("");
        System.out.println("stringArrayToMap = " + Arrays.toString(stringArrayToMap));
        Map<String, Long> mapString = Arrays.stream(stringArrayToMap).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("mapString = " + mapString);

        System.out.println("Ending converterArrayToSetMap...");
    }

    public static void converterListToMap() {
        System.out.println("Starting converterListToMap...");

        List<Long> listLong = Arrays.asList(4L, 3L, 2L, 1L, 5L, 1L, 1L, 2L, 3L);
        System.out.println("listLong = " + listLong);
        Map<Long, Long> longMap = listLong.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("longMap = " + longMap);

        List<String> listOfStrings = Arrays.asList("one", "two", "three", "four", "five");
        System.out.println("listOfStrings = " + listOfStrings);
        Map<Integer, String> mapFromList = listOfStrings.stream().collect(Collectors.toMap(String::length, Function.identity(), (existing, replacement) -> existing));
        System.out.println("mapFromList = " + mapFromList);
        Map<String, Integer> mapFromList2 = listOfStrings.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("mapFromList2 = " + mapFromList2);

        Map<String, Long> mapOfEntries = Map.ofEntries(
                Map.entry("one", 1L),
                Map.entry("two", 2L),
                Map.entry("three", 3L),
                Map.entry("four", 4L),
                Map.entry("five", 5L)
        );
        System.out.println("mapOfEntries = " + mapOfEntries);

        Map<String, Long> mapOf = Map.of(
                "one", 1L,
                "two", 2L,
                "three", 3L,
                "four", 4L,
                "five", 5L
        );
        System.out.println("mapOf = " + mapOf);

        Map<String, Long> mapPut = new HashMap<>();
        mapPut.put("one", 1L);
        mapPut.put("two", 2L);
        mapPut.put("three", 3L);
        mapPut.put("four", 4L);
        mapPut.put("five", 5L);
        System.out.println("mapPut = " + mapPut);

        List<String> listFromMapKeySet = new ArrayList<>(mapOfEntries.keySet());
        System.out.println("listFromMapKeySet = " + listFromMapKeySet);
        List<Long> listFromMapValues = new ArrayList<>(mapOfEntries.values());
        System.out.println("listFromMapValues = " + listFromMapValues);
        List<String> listFromMapToListMixed = mapOfEntries.entrySet().stream().map(entry -> entry.getKey() + "-" + entry.getValue()).collect(Collectors.toList());
        System.out.println("listFromMapToListMixed = " + listFromMapToListMixed);
        List<String> listFromMapToListKeys = mapOfEntries.keySet().stream().collect(Collectors.toList());
        System.out.println("listFromMapToListKeys = " + listFromMapToListKeys);
        List<Long> listFromMapToListValues = mapOfEntries.values().stream().collect(Collectors.toList());
        System.out.println("listFromMapToListValues = " + listFromMapToListValues);

        System.out.println("Ending converterListToMap...");
    }

    public static void flatMapper() {
        System.out.println("Starting flatMapper...");

        List<Long> listLongMap = List.of(3L, 2L, 1L);
        List<String> listStringMap = List.of("HELLO", "HI", "OMG", "WTF");

        //Se utiliza flatMap para combinar cada Long con cada String
        List<String> listResult = listLongMap.stream()
                .flatMap(x -> listStringMap.stream()
                        .map(y -> x + " " + y) // Concatenate each Long with each String
                ).collect(Collectors.toList());
        System.out.println("listResult = " + listResult);

        //Se utiliza flatMap para aplanar una lista de listas
        List<List<String>> names = Arrays.asList(
                Arrays.asList("Ana", "Luis"),
                Arrays.asList("Juan", "Sofia")
        );
        List<String> flatList = names.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("flatList = " + flatList);

        //Se utiliza flatMap para dividir frases en palabras
        List<String> frases = Arrays.asList("Hola mundo", "Java Streams");
        List<String> palabras = frases.stream()
                .flatMap(frase -> Arrays.stream(frase.split(" ")))
                .collect(Collectors.toList());
        System.out.println("palabras = " + palabras);

        System.out.println("Ending flatMapper...");
    }

    public static void iterator() {
        System.out.println("Starting iterator...");

        // Array int for-each loop
        int[] arrayInteger = {3, 2, 1, 2, 3, 4, 3};
        for (int item : arrayInteger) {
            System.out.println("item = " + item);
        }

        // Array char for-each loop
        String chainsaw = "chainsaw";
        char[] arrayChar = chainsaw.toCharArray();
        for (char item : arrayChar) {
            System.out.println("item = " + item);
        }

        // Map iteration
        Map<String, Long> mapStringLong = Map.of("A", 2L, "B", 3L, "C", 1L);
        for (Map.Entry<String, Long> item : mapStringLong.entrySet()) {
            System.out.println("item = " + item.getKey() + "--" + item.getValue());
        }

        // Using forEach method on Map
        mapStringLong.forEach((k, v) -> System.out.println(k + "--" + v));

        // Iterating over keys in Map
        for (String clave : mapStringLong.keySet()) {
            System.out.println("Clave: " + clave);
        }

        // Iterating over values in Map
        for (Long valor : mapStringLong.values()) {
            System.out.println("Valor: " + valor);
        }

        // Using forEach method on Map
        mapStringLong.forEach((key, value) -> {
            String tmp = key + "--" + value;
            System.out.println("tmp = " + tmp);
        });

        // List iteration
        List<Long> listLong = List.of(1L, 2L, 5L, 8L);
        for (Long item : listLong) {
            System.out.println("item = " + item);
        }

        // Using forEach method on List with method reference
        listLong.forEach(System.out::println);

        // Using forEach method on List
        listLong.forEach(c -> System.out.println("c = " + c));

        // Using forEach method with lambda expression
        listLong.forEach(item -> {
            String tmp = "item = " + item;
            System.out.println(tmp);
        });

        // set iteration
        Set<String> paises = Set.of("Colombia", "Argentina", "México");
        for (String pais : paises) {
            System.out.println("País: " + pais);
        }

        System.out.println("Ending iterator...");
    }

    public static void modifier() {
        System.out.println("Starting modifier...");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        List<String> listModified = listString.stream().map(x -> x.concat("***")).collect(Collectors.toList());
        System.out.println("listModified = " + listModified);

        Map<Long, String> mapLongString = Map.of(2L, "HELLO", 4L, "HI", 3L, "OMG", 1L, "OH");
        Map<Long, String> mapModifiedValue = mapLongString.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().concat("###")));
        Map<Long, String> mapModifiedValue2 = mapLongString.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, x -> x.getValue().concat("&&&")));
        System.out.println("mapModifiedValue = " + mapModifiedValue);
        System.out.println("mapModifiedValue2 = " + mapModifiedValue2);

        List<String> listStringMap = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        Map<String, Long> mapListModified = listStringMap.stream().filter(x -> x.length() > 2).map(x -> x.concat("***")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> mapListModified2 = listStringMap.stream().filter(x -> x.length() > 2).map(x -> x.concat("***")).collect(Collectors.toMap(Function.identity(), x -> (long) x.length()));
        System.out.println("mapListModified = " + mapListModified);
        System.out.println("mapListModified2 = " + mapListModified2);

        Map<Long, String> mapToListString = Map.of(2L, "HELLO", 4L, "HI", 3L, "OMG", 1L, "OHF");
        List<String> listMapModified = mapToListString.entrySet().stream().filter(x -> x.getValue().length() > 2).map(x -> x.getKey() + "-" + x.getValue()).collect(Collectors.toList());
        System.out.println("listMapModified = " + listMapModified);

        System.out.println("Ending modifier...");
    }

    public static void reducer() {
        System.out.println("Starting reducer...");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        String result = listString.stream().reduce("HEADER_", (x, y) -> x.concat(y).concat("**"));
        System.out.println("result = " + result);
        String maxStringCollection = Collections.max(listString);
        System.out.println("maxStringCollection = " + maxStringCollection);
        String minStringCollection = Collections.min(listString);
        System.out.println("minStringCollection = " + minStringCollection);

        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer minResult = listInteger.stream().min(Integer::compare).orElse(0);
        System.out.println("minResult = " + minResult);
        Integer maxResult = listInteger.stream().max(Integer::compare).orElse(0);
        System.out.println("maxResult = " + maxResult);

        Integer minCollections = Collections.min(listInteger);
        System.out.println("minCollections = " + minCollections);
        Integer maxCollections = Collections.max(listInteger);
        System.out.println("maxCollections = " + maxCollections);

        Integer sumResult = listInteger.stream().reduce(0, Integer::sum);
        System.out.println("sumResult = " + sumResult);
        Integer productResult = listInteger.stream().reduce(1, (x, y) -> x * y);
        System.out.println("productResult = " + productResult);
        Integer productResult2 = listInteger.stream().reduce(1, Math::multiplyExact);
        System.out.println("productResult2 = " + productResult2);

        System.out.println("Ending reducer...");
    }

    public static void sorter() {
        System.out.println("Starting sorter...");

        int[] intArray = {1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 5};
        Arrays.sort(intArray);
        System.out.println("intArray = " + Arrays.toString(intArray));

        //Collections.reverseOrder() does not work with primitive types like int, so we use Integer[]
        Integer[] integerArray = {1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 5};
        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println("integerArray = " + Arrays.toString(integerArray));

        char[] charArray = {'a', 'b', 'c', 'b', 'a', 'b', 'd'};
        Arrays.sort(charArray);
        System.out.println("charArray = " + Arrays.toString(charArray));

        //Collections.reverseOrder() does not work with primitive types like char, so we use Character[]
        Character[] characterArray = {'a', 'b', 'c', 'b', 'a', 'b', 'd'};
        Arrays.sort(characterArray, Collections.reverseOrder());
        System.out.println("characterArray = " + Arrays.toString(characterArray));

        // List.of creates an immutable list, so we cannot sort it directly.
        // List<Long> listLong = List.of(1L, 2L, 3L, 4L, 5L, 4L, 3L, 2L, 1L, 2L, 5L);
        // Instead, we create a mutable list from it.
        List<Long> listLong = new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L, 4L, 3L, 2L, 1L, 2L, 5L));
        Collections.sort(listLong);
        System.out.println("listLong = " + listLong);

        // Arrays.asList creates a mutable list, so we can sort it directly.
        List<Long> listLongReversed = Arrays.asList(1L, 2L, 3L, 4L, 5L, 4L, 3L, 2L, 1L, 2L, 5L);
        Collections.sort(listLongReversed, Collections.reverseOrder());
        System.out.println("listLongReversed = " + listLongReversed);

        //new ArrayList<>(List.of(...)) creates a mutable list from an immutable list.
        List<String> listString = new ArrayList<>(List.of("a", "b", "c", "b", "a", "b", "e"));
        listString.sort(Collections.reverseOrder());
        System.out.println("listString = " + listString);
        Collections.sort(listString);
        System.out.println("listString sorted = " + listString);

        // Arrays.asList creates a mutable list, so we can sort it directly.
        List<String> listStringReversed = Arrays.asList("a", "b", "c", "b", "a", "b", "e");
        listStringReversed.sort(Collections.reverseOrder());
        System.out.println("listStringReversed = " + listStringReversed);
        Collections.sort(listStringReversed);
        System.out.println("listStringReversed sorted = " + listStringReversed);

        // Using TreeMap to sort by keys
        TreeMap<Long, Long> mapLong = new TreeMap<>();
        mapLong.put(2L, 7L);
        mapLong.put(1L, 3L);
        mapLong.put(3L, 1L);
        System.out.println("mapLong = " + mapLong);
        // Using stream to sort by values
        mapLong.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        // Using stream to sort by values in reverse order
        mapLong.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        // Collecting sorted entries into a new LinkedHashMap to maintain order
        Map<Long, Long> sortedMap = mapLong.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (c1, c2) -> c1, LinkedHashMap::new));
        System.out.println("sortedMap = " + sortedMap);

        // Using TreeMap with reverse order comparator by keys
        TreeMap<Long, Long> treeMapLong = new TreeMap<>(Comparator.reverseOrder());
        treeMapLong.putAll(mapLong);
        System.out.println("treeMapLong = " + treeMapLong);

        // Using TreeSet to sort a set of integers, no duplicates allowed
        Set<Integer> integerSet = new TreeSet<>(Arrays.asList(5, 3, 1, 4, 2, 2, 2));
        System.out.println("integerSet = " + integerSet);

        // Using TreeSet with a custom comparator to sort in reverse order
        Set<Integer> integerSetReversed = new TreeSet<>(Collections.reverseOrder());
        integerSetReversed.addAll(Arrays.asList(5, 3, 1, 4, 2, 2, 2));
        System.out.println("integerSetReversed = " + integerSetReversed);

        // Using TreeSet with a custom comparator to sort characters in reverse order
        Set<Character> characterSet = new TreeSet<>(Collections.reverseOrder());
        characterSet.addAll(Arrays.asList('a', 'b', 'c', 'b', 'a', 'b', 'd'));
        System.out.println("characterSet = " + characterSet);

        // Using TreeSet with a custom comparator to sort strings in reverse order
        Set<String> stringSet = new TreeSet<>(Collections.reverseOrder());
        stringSet.addAll(Arrays.asList("a", "b", "c", "b", "a", "b", "e"));
        System.out.println("stringSet = " + stringSet);

        // Using TreeSet with a custom comparator to sort strings in natural order
        Set<String> stringSetNaturalOrder = new TreeSet<>();
        stringSetNaturalOrder.addAll(Arrays.asList("a", "b", "c", "b", "a", "b", "e"));
        System.out.println("stringSetNaturalOrder = " + stringSetNaturalOrder);

        System.out.println("Ending sorter...");
    }


    public static void stringFunctions() {
        System.out.println("Starting stringFunctions...");

        String chainsaw = "chainsaw";
        System.out.println("chainsaw = " + chainsaw);
        System.out.println("chainsaw.toUpperCase() = " + chainsaw.toUpperCase());
        System.out.println("chainsaw.toLowerCase() = " + chainsaw.toLowerCase());
        System.out.println("chainsaw.length() = " + chainsaw.length());
        System.out.println("chainsaw.charAt(0) = " + chainsaw.charAt(0));
        System.out.println("chainsaw.indexOf('a') = " + chainsaw.indexOf('a'));
        System.out.println("chainsaw.lastIndexOf('a') = " + chainsaw.lastIndexOf('a'));
        System.out.println("chainsaw.substring(2, 5) = " + chainsaw.substring(2, 5));
        System.out.println("chainsaw.replace('a', 'o') = " + chainsaw.replace('a', 'o'));
        System.out.println("chainsaw.contains(\"s\") = " + chainsaw.contains("s"));
        System.out.println("chainsaw.startsWith(\"ch\") = " + chainsaw.startsWith("ch"));
        System.out.println("chainsaw.endsWith(\"w\") = " + chainsaw.endsWith("w"));
        System.out.println("chainsaw.split(\"a\") = " + Arrays.toString(chainsaw.split("a")));

        String[] words = {"Hello", "World"};
        String joinedWords = String.join(", ", words);
        System.out.println("joinedWords = " + joinedWords);

        List<String> stringList = List.of("Hello".split(""));
        String stringJoin = String.join("-", stringList);
        System.out.println("stringJoin = " + stringJoin);

        String[] splitChainsaw = chainsaw.split("");
        System.out.println("splitChainsaw = " + Arrays.toString(splitChainsaw));

        String joinedSplitChainsaw = String.join("-", splitChainsaw);
        System.out.println("joinedSplitChainsaw = " + joinedSplitChainsaw);

        String replacedChainsaw = chainsaw.replaceAll("[aeiou]", "*");
        System.out.println("replacedChainsaw = " + replacedChainsaw);

        String trimmedChainsaw = "   chainsaw   ";
        System.out.println("trimmedChainsaw.trim() = '" + trimmedChainsaw.trim() + "'");

        String formattedString = String.format("%s is a %s", chainsaw, "tool");
        System.out.println("formattedString = " + formattedString);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append(" World");
        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" World");
        System.out.println("stringBuffer.toString() = " + stringBuffer.toString());

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("str1 == str2: " + (str1 == str2)); // true, same reference
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true, same content
        String str3 = new String("Hello");
        System.out.println("str1 == str3: " + (str1 == str3)); // false, different reference
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, same content

        System.out.println("Ending stringFunctions...");
    }

    public static void teenier() {
        System.out.println("Starting teenier...");

        List<Integer> listString = List.of(100, 200, 300, 400, 500);
        var listInteger = listString.stream().collect(Collectors.teeing(
                Collectors.filtering(x -> x < 300, Collectors.mapping(x -> x / 2, Collectors.toList())),
                Collectors.filtering(x -> x > 300, Collectors.mapping(x -> x * 2, Collectors.toList())),
                (x, y) -> Stream.concat(x.stream(), y.stream()).toList()
        ));
        System.out.println("listInteger = " + listInteger);

        // Example of using teeing with a custom collector
        List<String> listString2 = List.of("apple", "banana", "cherry", "date", "elderberry");
        var listStringResult = listString2.stream().collect(Collectors.teeing(
                Collectors.filtering(s -> s.length() < 6, Collectors.mapping(String::toUpperCase, Collectors.toList())),
                Collectors.filtering(s -> s.length() >= 6, Collectors.mapping(String::toLowerCase, Collectors.toList())),
                (x, y) -> Stream.concat(x.stream(), y.stream()).toList()
        ));
        System.out.println("listStringResult = " + listStringResult);

        // Example of using teeing with a custom collector and a predicate
        List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var listNumbersResult = listNumbers.stream().collect(Collectors.teeing(
                Collectors.filtering(n -> n % 2 == 0, Collectors.mapping(n -> n * 2, Collectors.toList())),
                Collectors.filtering(n -> n % 2 != 0, Collectors.mapping(n -> n * 3, Collectors.toList())),
                (x, y) -> Stream.concat(x.stream(), y.stream()).toList()
        ));
        System.out.println("listNumbersResult = " + listNumbersResult);

        // Example of using teeing with summing and averaging
        List<Integer> listNumbers2 = List.of(10, 20, 30, 40, 50);
        String resultString2 = listNumbers2.stream().collect(Collectors.teeing(
                Collectors.summingInt(Integer::intValue),
                Collectors.averagingInt(i -> i),
                (sum, average) -> String.format("Sum: %d, Average: %.2f", sum, average)
        ));
        System.out.println("resultString2 = " + resultString2);

        // Example of using teeing to find min and max values in a list
        List<Integer> listNumbers3 = List.of(5, 3, 9, 1, 7);
        Map<String, Integer> minMax = listNumbers3.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy((a, b) -> Integer.compare(a, b)),
                (min, max) -> Map.of("min", min.get(), "max", max.get())
        ));
        System.out.println("minMax = " + minMax);

        // Example of using teeing to find min and max values and return them in a list
        List<Integer> minMaxList = listNumbers3.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (min, max) -> List.of(min.orElse(0), max.orElse(0))
        ));
        int min = minMaxList.get(0);
        int max = minMaxList.get(1);
        int difference = max - min;
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("difference = " + difference);

        // Example of using teeing to find min and max values and return them in a map
        Map<String, Integer> minMaxMap = listNumbers3.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (minValue, maxValue) -> {
                    Map<String, Integer> resultMap = new HashMap<>();
                    resultMap.put("min", minValue.orElse(0));
                    resultMap.put("max", maxValue.orElse(0));
                    return resultMap;
                }
        ));
        int minValue = minMaxMap.get("min");
        int maxValue = minMaxMap.get("max");
        int differenceValue = maxValue - minValue;
        System.out.println("minValue = " + minValue);
        System.out.println("maxValue = " + maxValue);
        System.out.println("differenceValue = " + differenceValue);

        // Example of using teeing to count and average values in a list
        List<Number> listNumberResult = listNumbers3.stream().collect(Collectors.teeing(
                Collectors.counting(), //long count
                Collectors.averagingInt(Integer::intValue), //double average
                (count, average) -> List.of(count, average)
        ));
        long count = (Long) listNumberResult.get(0);
        double average = listNumberResult.get(1).doubleValue();
        System.out.println("count = " + count);
        System.out.println("average = " + average);

        // Example of using teeing to filter and sum positive and negative numbers
        List<Integer> positiveNegative = List.of(-5, 3, -9, 1, 7, -2, 4);
        List<Integer> resultPositiveNegative = positiveNegative.stream().collect(Collectors.teeing(
                Collectors.filtering(x -> x > 0, Collectors.summingInt(Integer::intValue)),
                Collectors.filtering(x -> x < 0, Collectors.summingInt(x -> x)),
                (positiveSum, negativeSum) -> List.of(positiveSum, negativeSum)
        ));
        int positiveSum = resultPositiveNegative.get(0);
        int negativeSum = resultPositiveNegative.get(1);
        System.out.println("positiveSum = " + positiveSum);
        System.out.println("negativeSum = " + negativeSum);

        System.out.println("Ending teenier...");
    }

    public static void filter() {
        System.out.println("Starting filter...");

        List<String> listString = List.of("HELLO", "HI", "OMG", "WTF", "OH");
        List<String> filteredList = listString.stream().filter(x -> x.length() >= 3).collect(Collectors.toList());
        System.out.println("filteredList = " + filteredList);

        Map<Long, String> mapLongString = Map.of(1L, "HELLO", 2L, "HI", 3L, "OMG", 4L, "OH");
        HashMap<Long, String> mapLongStringFiltered = mapLongString.entrySet().stream().
                filter(x -> x.getValue().length() >= 3).
                collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (s1, s2) -> s1, HashMap::new)
                );
        System.out.println("mapLongStringFiltered = " + mapLongStringFiltered);

        HashMap<Long, String> mapLongStringFiltered2 = mapLongString.entrySet().stream().
                filter(x -> x.getKey() > 2).
                collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (s1, s2) -> s1, HashMap::new)
                );
        System.out.println("mapLongStringFiltered2 = " + mapLongStringFiltered2);

        System.out.println("Ending filter...");
    }

}