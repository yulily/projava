package projava.part4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        try (
                // ポート1600 で通信を待ち受ける、1023まで用途決まってるので 1024以降
                var server = new ServerSocket(1700);
                // クライアントからの接続を待ち受ける、接続があったらやり取りするための Socketオブジェクトが返される
                Socket soc = server.accept();
                // データ受信には InputStream を使う
                // ソケットに対してデータ受信するときは getInputStream で InputStream オブジェクトを取得
                InputStream input = soc.getInputStream();
        ) {
            System.out.println("connect from " + soc.getInetAddress());
            // read でデータを受信
            System.out.println(input.read());
        }
    }
}
