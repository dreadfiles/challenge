package org.challenge;

import java.util.Arrays;
import java.util.Map;

public class QuotaValidatorStream {

    public static void main(String[] args) {
        System.out.println("Start");

        String inputString = "{[hello[](hi)[()]]}";
        String openers = "{[(";
        Map<String, String> closers = Map.ofEntries(
                Map.entry("}", "{"),
                Map.entry("]", "["),
                Map.entry(")", "(")
        );

        var result = Arrays.stream(inputString.split("")).reduce(
                "",
                (x, y) -> {
                    if (openers.contains(y)) {
                        return x.concat(y);
                    }
                    if(closers.containsKey(y)){
                        if(x.isEmpty()) {
                            return x;
                        }
                        if(x.substring(0, x.length() - 1).compareTo(y) == 0){
                            return x;
                        }
                        return x.substring(0, x.length() - 1);
                    }
                    return x;
                });

        System.out.println("valid string: " + result.isEmpty());

        System.out.println("End");
    }

}
