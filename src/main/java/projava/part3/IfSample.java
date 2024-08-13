package projava.part3;

public class IfSample
{
    public static void main(String[] args) {
        var a = 9;
        if (a < 3) System.out.println("ちいさい");

        if (a < 3) {
            System.out.println("小");
        } else if (a < 7) {
            System.out.println("中");
        } else {
            System.out.println("大");
        }
    }
}
