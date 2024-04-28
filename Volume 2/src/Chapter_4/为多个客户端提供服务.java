package Chapter_4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/15 下午5:02
 * @description 为多个客户端提供服务
 **/
public class 为多个客户端提供服务 {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws IOException {
        try (var s = new ServerSocket(23333)) {
            int i = 1;
            while ( true ) {
                Socket incoming = s.accept();
                System.out.println("当前第" + i + "个客户端连接");
                Runnable r = new ThreadedEchoHandler(incoming);
                executorService.submit(r);
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("服务器关闭");
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream();
             var in = new Scanner(inStream, StandardCharsets.UTF_8);
             var out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true)) {
            out.println("Hello! Enter BYE to exit.");
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
