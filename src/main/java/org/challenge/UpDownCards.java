package org.challenge;

import java.util.LinkedList;
import java.util.List;

public class UpDownCards {

    public static void main(String[] args) {
        List<String> list = List.of("5 de diamantes", "3 de picas", "1 de corazon", "as de corazones", "4 de treboles", "3 de treboles");
        LinkedList<String> link = new LinkedList<>();
        list.forEach(c -> {
            int index = list.indexOf(c);
            if (index == 0) {
                link.add(c);
            } else if (index % 2 != 0) {
                link.addLast(c);
            } else {
                link.addFirst(c);
            }
        });

        System.out.println("link = " + link);
    }
}
