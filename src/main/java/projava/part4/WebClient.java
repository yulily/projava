package projava.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient {
    public static void main(String[] args) throws IOException {
        var domain = "example.com";
        // Unicodeを効率よく処理できる UTF-16 が Java 内部の文字エンコーディングで使われている
        // データの送受信では UTF-8 と UTF-16 の変換が必要になる
        // 文字エンコーディングの変換を行ってくれるのが、Readerクラスと Writerクラス
        try (
                // HTTP は TCP を使ったプロトコルのため Socket を使用
                var soc = new Socket(domain, 80);
                // 出力用に OutputStream から PrintWriter オブジェクト生成
                var pw = new PrintWriter(soc.getOutputStream());
                // 入力用に InputStream から InputStreamReader -> BufferedReader オブジェクトを生成
                var isr = new InputStreamReader(soc.getInputStream());
                var bur = new BufferedReader(isr);
        ) {
            // HTTPリクエスト
            // HTTPメソッド
            pw.println("GET /index.html HTTP/1.1");
            // リクエストヘッダー
            pw.println("Host:" + domain);
            // 空行を送るとリクエストは終了
            // println は LF、HTTP での改行コードは CR+LF なので異なる ※ライブラリ使うのがお勧め
            pw.println();
            // ソケットへの出力はある程度まとまってから行う仕組みになっているため、強制送信
            pw.flush();

            //HTTPレスポンス
            bur.lines()
                    // 18行分表示
                    .limit(18)
                    .forEach(System.out::println);
        }
    }
}
