package org.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class Maximizer {

    public static Map<Integer, Integer> validateList(List<Integer> inputList) {
        return inputList.stream().collect(Collectors.toMap(value -> value, Maximizer::maximizeNumber));
    }

    public static Integer maximizeNumber(Integer input) {
        String inputString = String.valueOf(Math.abs(input));
        List<String> inputList = new ArrayList<String>(Arrays.asList(inputString.split(Constant.ITEM_DELIMITER)));

        if (input >= 0) {
            Collections.sort(inputList);
            String elementToBeRemoved = inputList.stream().filter(item -> !item.equals(Constant.ITEM_ZERO)).findFirst().orElse(Constant.ITEM_ZERO);
            inputList.remove(elementToBeRemoved);
            inputList.add(Constant.ITEM_FIRST_POSITION, elementToBeRemoved);
        } else {
            Collections.sort(inputList, Collections.reverseOrder());
            inputList.add(Constant.ITEM_FIRST_POSITION, Constant.ITEM_NEGATIVE);
        }

        return Integer.valueOf(String.join(Constant.ITEM_DELIMITER, inputList));
    }
}
