package projava.part3;

import java.util.List;
import java.util.stream.IntStream;

public class MethodRefSample {

    public static void main(String[] args) {
        IntStream.range(0, 3)
                // ラムダ式
                .map(x -> MethodSample.twice(x))
                .forEach(System.out::println);

        IntStream.range(0, 3)
                // メソッド参照として渡す
                .map(MethodRefSample::twice)
                .forEach(System.out::println);
        // ラムダ式で受け取った引数をメソッドにそのまま渡してるものは、メソッド参照に置換可能

        System.out.println(
                IntStream.of(3,5,6).mapToObj(MethodRefSample::repeatString).toList()
        );

        var names = List.of("yusuke", "kis", "sugiyama");
        System.out.println(
                names.stream().map(MethodRefSample::upper).toList()
        );
        System.out.println(
                names.stream().map(MethodRefSample::showName).toList()
        );
        System.out.println(
                names.stream().map(MethodRefSample::upper).toList().stream().map(n -> lower(n)).toList()
        );
    }

    private static int twice(int i) {
        return i * 2;
    }

    private static String repeatString(int i) {
        return "*".repeat(i);
    }

    private static String upper(String s) {
        return s.toUpperCase();
    }

    private static String showName(String s) {
        return "%sさん".formatted(s);
    }

    private static String lower(String s) {
        return s.toLowerCase();
    }
}
