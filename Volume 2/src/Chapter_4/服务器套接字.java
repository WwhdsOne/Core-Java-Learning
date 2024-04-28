package Chapter_4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/15 下午4:54
 * @description 服务器套接字
 **/
public class 服务器套接字 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(23333)) {
            try (Socket socket = s.accept()) {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try (var in = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    var out = new PrintWriter(outputStream, true);
                    out.println("Hello! Enter BYE to exit.");
                    boolean done = false;
                    while ( !done && in.hasNextLine() ) {
                        String line = in.nextLine();
                        System.out.println("Echo: " + line);
                        out.println("Echo: " + line);
                        if ( line.trim().equals("BYE") ) {
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
