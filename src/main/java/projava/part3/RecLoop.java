package projava.part3;

public class RecLoop {
    public static void main(String[] args) {
        loop(0);
        down(5);
    }

    private static void loop(int i) {
        if (i >= 5) {
            return;
        }

        System.out.println(i);
        loop(i + 1);
    }

    private static void down(int i) {
        if (i <= 0) {
            return;
        }

        System.out.println(i);
        down(i - 1);
    }
}
