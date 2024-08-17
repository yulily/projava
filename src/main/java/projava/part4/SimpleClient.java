package projava.part4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        try (
                // 接続先を指定し Socketオブジェクトを作成
                var soc = new Socket("localhost", 1700);
                // データ送信には OutputStream を使う
                // ソケットに対してデータ送信するときは getOutputStream で OutputStream オブジェクトを取得
                OutputStream is = soc.getOutputStream();
        ) {
            // writeメソッドでデータを送信 0-255 を送れる
            is.write(234);
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
            System.out.println("サーバーが起動していません");
        }
    }
}
