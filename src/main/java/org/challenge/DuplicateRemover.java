package org.challenge;

/* Remove triplicates from Sorted Array */
public class DuplicateRemover {

    public static int[] execute(int[] input) {
        int inputLength = input.length;
        int[] resultArray = new int[inputLength];
        int indexNoDuplicates = 0;
        int previousValue = -1;

        for (int index = 0, counter = 1; index < inputLength; index++) {
            int currentValue = input[index];

            if (previousValue == currentValue) {
                counter++;
            } else {
                counter = 1;
                previousValue = currentValue;
            }

            if (counter <= 2) {
                resultArray[indexNoDuplicates] = currentValue;
                indexNoDuplicates++;
            }
        }

        return resultArray;
    }
}