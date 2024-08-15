package projava.part4;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileIOSample {
    public static void main(String[] args) {
        // catch して処理をするか throw句で誰かに押し付けないといけない検査例外と
        // コード中で処理をしなくてもいい非検査例外がある
        // 例外はすべて Throwable というクラスに属する
        // その下で Error と Exception に分類される
        // Error か Exception > RuntimeException に属する例外は非検査例外
        // それ以外は検査例外
        try {

            var message = """
                test
                message
                """;
            var writeFile = Path.of("test.txt");
            Files.writeString(writeFile, message);

            var readFile = Path.of("tst2.txt");
            String s = Files.readString(readFile);
            System.out.println(s);
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません: " + e.getFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }
}
