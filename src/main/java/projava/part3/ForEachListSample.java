package projava.part3;

import java.util.ArrayList;
import java.util.List;

public class ForEachListSample {
    public static void main(String[] args) {
        var names = List.of("yusuke", "kis", "sugiyama");
        for (int i = 0; i < names.size(); i++) {
            var name = names.get(i);
            System.out.println(name);
        }
        for (var name : names) {
            System.out.println(name);
        }

        var names2 = new String[]{"yusuke", "kis", "sugiyama"};
        for (String name : names2) {
            System.out.println(name);
        }

        var data = List.of("apple", "banana", "grape");
        var newData = new ArrayList<String>();
        for (String fruit : data) {
            if (fruit.length() == 5) {
                System.out.println(fruit);
                newData.add(fruit);
            }
        }
        System.out.println(newData.size());
        int pCount = 0;
        for (String newFruit : newData) {
            if (newFruit.contains("p")) {
                pCount++;
            }
        }
        if (newData.size() == pCount) {
            System.out.println("all p");
        }
        if (pCount >= 1) {
            System.out.println("has p");
        }

        var hasP = false;
        var allP = true;
        for (String fruit : newData) {
            if (fruit.contains("p")) {
                hasP = true;
            } else {
                allP = false;
            }
            if (hasP && !allP) {
                break;
            }
        }
        System.out.println(allP);
        System.out.println(hasP);

        var newData3 = new ArrayList<String>();
        data.stream().filter(fruit -> fruit.length() == 5).forEach(fruit -> {
            System.out.println(fruit);
            newData3.add(fruit);
        });
        System.out.println(newData3);
    }
}
