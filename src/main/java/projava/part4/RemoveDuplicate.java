package projava.part4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {
    public static void main(String[] args) {
        var data = "abcccbaaabcc";

        var builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (i > 0 && ch == data.charAt(i - 1)) {
                continue;
            }
            builder.append(ch);
        }

        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);

        // 拡張 for
        char prev = 0;
        var builder2 = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if (ch == prev) {
                continue;
            }
            builder2.append(ch);
            prev = ch;
        }
        var result2 = builder2.toString();
        System.out.println(data);
        System.out.println(result2);

        System.out.println(swapOddEven("abcde"));
        System.out.println(swapOddEven2("abcde"));
        Integer[] numbers = {3,6,9,4,2,1,5};
        System.out.println(Arrays.toString(filterGreaterThanPrevious(numbers)));
    }

    private static String swapOddEven(String chars) {
        var builder = new StringBuilder();
        for (int i = 1; i <= chars.length(); i++) {
            if (i == chars.length()) {
                builder.append(chars.charAt(i - 1));
                break;
            }

            if (i % 2 == 0) {
                builder.append(chars.charAt(i - 1));
                builder.append(chars.charAt(i - 2));
            }
        }
        return builder.toString();
    }

    private static String swapOddEven2(String chars) {
        var builder = new StringBuilder();
        // 偶数だけ回す
        for (int i = 0; i < chars.length(); i += 2) {
            if (i + 1 < chars.length()) {
                // 文字数超えない時だけ奇数を先に入れる
                builder.append(chars.charAt(i + 1));
            }

            builder.append(chars.charAt(i));
        }
        return builder.toString();
    }

    private static Integer[] filterGreaterThanPrevious(Integer[] intArray) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            if (i == intArray.length - 1) {
                result.add(intArray[i]);
                break;
            }
            result.add(Math.max(intArray[i], intArray[i + 1]));
        }

        return result.toArray(new Integer[0]);
    }
}
