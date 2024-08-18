package projava.part4;

import java.util.List;

public class InterfaceSample {
    // 実装すべきメソッドが 1つだけの interface は関数型インターフェースという
    // アノテーションは必須ではないが、ラムダ式を受け取ることを前提としたインフタフェースには指定する
    @FunctionalInterface
    interface Named {
        String name();
        // デフォルトメソッド
        // interface は protected は指定できない、省略すると public (classの場合は指定なし / パッケージ内で使用可)
        default String greeting() {
            return "こんにちは%sさん".formatted(name());
        }
    }

    record Student(String name, int score) implements Named {}
    record Teacher(String name, String subject) implements Named {}
    record Staff(String name, String job) implements Named {}

    static class Pasenger implements Named {
        @Override
        public String name() {
            return "通りすがり";
        }
    }

    interface Figure {
        int width();
        int height();
    }

    record Box(int width, int height) implements Figure {}
    record Oval(int width, int height) implements Figure {}

    public static void main(String[] args) {
        var people = List.of(new Student("kis", 80), new Teacher("hosoya", "Math"), new Pasenger());
        for (Named p : people) {
            System.out.println("こんにちは%sさん".formatted(p.name()));
        }
    }
}
