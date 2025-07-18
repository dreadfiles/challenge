package org.challenge;

import java.util.Arrays;

public class CommonPrefix {

    public static void main(String[] args) {
        System.out.println("Start");

        String paragraph = "The world  is     yours";

        String[] splitParagraph = paragraph.split(" ");
        System.out.println("splitParagraph = " + Arrays.toString(splitParagraph));

        String[] splitParagraphRegex = paragraph.split("\\s+");
        System.out.println("splitParagraphRegex = " + Arrays.toString(splitParagraphRegex));

        String[] splitParagraphRegex2 = paragraph.split("\\s{2,}");
        System.out.println("splitParagraphRegex2 = " + Arrays.toString(splitParagraphRegex2));

        String[] splitParagraphRegex3 = paragraph.split("\\s{1,}");
        System.out.println("splitParagraphRegex3 = " + Arrays.toString(splitParagraphRegex3));

        String[] splitParagraphRegex4 = paragraph.split("\\s*");
        System.out.println("splitParagraphRegex4 = " + Arrays.toString(splitParagraphRegex4));

        System.out.println("End");
    }

}
