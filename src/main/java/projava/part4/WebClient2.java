package projava.part4;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WebClient2 {
    public static void main(String[] args) throws IOException {
        var domain = "www.google.com";
        // SSL/TLS を使う場合、Socketオブジェクトの取得に SSLSocketFactoryオブジェクトを使う
        SocketFactory factory = SSLSocketFactory.getDefault();
        try (
                var soc = factory.createSocket(domain, 443);
                var pw = new PrintWriter(soc.getOutputStream());
                var isr = new InputStreamReader(soc.getInputStream());
                var bur = new BufferedReader(isr);
        ) {
            pw.println("GET /index.html HTTP/1.1");
            pw.println("Host:" + domain);
            pw.println();
            pw.flush();

            bur.lines()
                    .limit(18)
                    .forEach(System.out::println);
        }
    }
}
