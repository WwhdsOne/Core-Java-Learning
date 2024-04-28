package Chapter_4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/15 下午5:25
 * @description 半关闭
 **/
public class 半关闭 {
    public static void main(String[] args) throws IOException {
        try(var s = new Socket("127.0.0.1",23333)){
            var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8);
            var writer = new PrintWriter(s.getOutputStream());
            System.out.println(in.nextLine());
            s.shutdownInput();
            writer.println("BYE");
            writer.flush();
        }
    }
}
