package projava.part4;

public class RunLengthCompression {
    public static void main(String[] args) {
        // 定数
        final var COUNTER_BASE = -1;
        var data = "abbcccbaaaabccccccccccccddd";
        var count = COUNTER_BASE;
        char prev = 0;
        var builder = new StringBuilder();
        for (var ch : data.toCharArray()) {
            if (prev == ch) {
                // 同じ文字が続く時
                count++;
                if (count == 9) {
                    builder.append('9');
                    count = COUNTER_BASE;
                    prev = 0;
                }
            } else {
                //違う文字が来た時
                if (count >= 0) {
                    // 前の文字が連続していたので数字を出力
                    builder.append((char) ('0' + count));
                    count = COUNTER_BASE;
                }
                builder.append(ch);
                prev = ch;
            }
        }
        // 最後の文字が連続していれば数字を出力
        if (count >= 0) {
            builder.append((char) ('0' + count));
        }
        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);

        System.out.println(upperAndLower("aa0bcd1efg1gg0abc"));
        System.out.println(repeatCharOnDigit("ab0c1ba2bc9cd1"));
        System.out.println(repeatCharOnDigit2("ab0c1ba2bc9cd1"));
    }

    private static String upperAndLower(String chars) {
        var builder = new StringBuilder();
        boolean isLower = true;
        for (char ch : chars.toCharArray()) {
            if (Character.toString(ch).equals("0")) {
                isLower = false;
                continue;
            }

            if (Character.toString(ch).equals("1")) {
                isLower = true;
                continue;
            }

            ch = isLower ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
            builder.append(ch);
        }

        return builder.toString();
    }

    private static String repeatCharOnDigit(String chars) {
        var builder = new StringBuilder();

        for (int i = 0; i < chars.length(); i++) {
            if (i > 0 && Character.isDigit(chars.charAt(i))) {
                builder.append(Character.toString(chars.charAt(i - 1)).repeat(Character.digit(chars.charAt(i), 10) + 1));
                continue;
            }

            builder.append(chars.charAt(i));
        }

        return builder.toString();
    }

    private static String repeatCharOnDigit2(String chars) {
        var builder = new StringBuilder();

        var pre = '0';
        for (var ch : chars.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                // 0 は先頭文字なので何もしない
                if (pre == '0') {
                    continue;
                }
                for (int i = 0; i < ch - '0' + 1; i++) {
                    builder.append(pre);
                }
            } else {
                pre = ch;
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
