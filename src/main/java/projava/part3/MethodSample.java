package projava.part3;

import java.util.stream.Stream;

public class MethodSample {
    record Student(String name, int englishScore, int mathScore) {
        // インスタンスメソッド
        int average() {
            return (this.englishScore() + this.mathScore()) / 2;
        }

        void showResult() {
            System.out.println("%sさんの平均点は %d点です" . formatted(name(), average()));
        }
    }

    public static void main(String[] args) {
        var result = twice(3);
        System.out.println(result);

        var kis = new Student("kis", 60, 80);
        kis.showResult();

        System.out.println(Stream.of("a","b", "y").map(s -> s.contains("y")).toList());
        Stream.of("a","b", "y").forEach(s -> System.out.println(s));

        System.out.println(upper("aiueo"));
        System.out.println(empty(""));
    }

    // staticメソッドから呼び出す同じクラス内のメソッドは
    // staticメソッドにする必要がある
    static int twice(int x) {
        return x * 2;
    }

    static String upper(String s) {
        return s.toUpperCase();
    }

    static Boolean empty(String s) {
        return s.isEmpty();
    }
}
