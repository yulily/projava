package projava.part4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebClient3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpResponse<String> response;
        try (
                // HttpClient の用意
                HttpClient client = HttpClient.newHttpClient()
        ) {
            URI uri = URI.create("https://example.com/");
            // HttpRequest の用意
            HttpRequest req = HttpRequest.newBuilder(uri).build();
            // HttpRequest 送信しレスポンス受け取る
            response = client.send(
                    req, HttpResponse.BodyHandlers.ofString()
            );
        }
        String body = response.body();
        body.lines()
                .limit(5)
                .forEach(System.out::println);
    }
}
