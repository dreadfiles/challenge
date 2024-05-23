package org.challenge;

import java.util.List;

public class CommonPrefix {

    public static void main(String[] args) {
        System.out.println("Start");

        String paragraph = "The world  is     yours";
        String[] splitParagraph = paragraph.split("\\s+");

        int wordCounter = splitParagraph.length;
        System.out.println("wordCounter = " + wordCounter);

        System.out.println("End");
    }

}
