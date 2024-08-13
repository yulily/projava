package projava.part3;

public class ForHello {
    public static void main(String[] args) {
        for (int n = 0; n < 3; n++) {
            System.out.println("projava.part1.Hello");
        }
        for (int n = 0; n < 10; n++) {
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 1; n <= 10; n++) {
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 0; n < 35; n+=5) {
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 20; n > 0; n-=3) {
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 0; n < 10; n++) {
            if (n == 3) continue;
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 0; n < 10; n++) {
            if (n == 3 || n == 5) continue;
            System.out.println(n);
        }
        System.out.println("=======");
        for (int n = 0; n < 10; n++) {
            if (n >= 3 && n <= 6) continue;
            System.out.println(n);
        }
    }
}
