package projava.part3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        var strs = List.of("apple", "banana", "orange", "pineapple");
        System.out.println(strs.stream().filter(s -> s.length() > 5).collect(Collectors.joining()).length());
        System.out.println(IntStream.range(0,3).mapToObj(n->"test").collect(Collectors.joining()));
    }
}
