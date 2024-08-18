package projava.part4;

public class CheckFloat {

    enum FloatState {
        START, // 初期状態
        INT, // 1-9
        FRAC_START, // 小数部開始
        FRAC, // 小数部
        ZERO, // 0
        MINUS_SIGN, // 負の符号
        FRAC_ZERO // 小数部 0
    }

    static boolean check(String data) {
        var state = FloatState.START;
        for (char ch : data.toCharArray()) {
            switch (state) {
                case START -> {
                    // 開始
                    if (ch == '0') {
                        state = FloatState.ZERO;
                    } else if (ch >= '1' && ch <= '9') {
                        state = FloatState.INT;
                    } else if (ch == '-') {
                        state = FloatState.MINUS_SIGN;
                    }else {
                        return false;
                    }
                }
                case ZERO -> {
                    // 先頭がゼロ
                    if (ch == '.') {
                        state = FloatState.FRAC_START;
                    } else {
                        return false;
                    }
                }
                case INT -> {
                    if (ch >= '0' && ch <= '9') {
                        state = FloatState.INT;
                    } else if (ch == '.') {
                        state = FloatState.FRAC_START;
                    } else {
                        return false;
                    }
                }
                case FRAC_START, FRAC, FRAC_ZERO -> {
                    if (ch > '0' && ch <= '9') {
                        state = FloatState.FRAC;
                    } else if (ch == '0') {
                        state = FloatState.FRAC_ZERO;
                    } else {
                        return false;
                    }
                }
                case MINUS_SIGN -> {
                    if (ch == '0') {
                        state = FloatState.ZERO;
                    } else if (ch > '0' && ch <= '9') {
                        state = FloatState.INT;
                    } else {
                        return false;
                    }
                }
            }
        }
        return switch (state) {
            case ZERO, INT, FRAC -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        System.out.println(check(""));
        System.out.println(check("012"));
        System.out.println(check(".12"));
        System.out.println(check("12."));
        System.out.println(check("1.2.3"));
        System.out.println(check("1..3"));
        System.out.println(check("0"));
        System.out.println(check("12"));
        System.out.println(check("12.3"));
        System.out.println(check("0.3"));
        System.out.println(check("-123"));
        System.out.println(check("-123.1"));
        System.out.println(check("12.30"));
        System.out.println(check("12.03"));
        System.out.println(check("12.0"));
        System.out.println(check("--123"));
        System.out.println(check("-12-3"));

        System.out.println(check("-12.304"));
        System.out.println(check("--12.3004"));
        System.out.println(check("1-2.3004"));
        System.out.println(check("-.3004"));
        System.out.println(check("-00.3004"));
    }
}
