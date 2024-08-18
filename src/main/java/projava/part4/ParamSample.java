package projava.part4;

import java.util.Arrays;

public class ParamSample {
    /**
     * プログラム開始時に呼び出される
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // 引数の内容を表示
        System.out.println(Arrays.toString(args));
    }
}

/**
 * public ではないアウタークラス
 * 複数のアウタークラスをひとつのファイルに定義できることを示すため
 */
class Dummy {
}
