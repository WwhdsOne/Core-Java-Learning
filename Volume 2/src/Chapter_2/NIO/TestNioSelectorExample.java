package Chapter_2.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestNioSelectorExample {

    public static void main(String[] args) {
        // Start the server in a new thread
        new Thread(() -> NioSelectorExample.main(new String[]{})).start();

        // Wait for the server to start
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test the server
        try (Socket socket = new Socket("localhost", 8080)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Send some data to the server
            out.write("Hello, Server!".getBytes());
            out.flush();

            // Read the response from the server
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);

            if (bytesRead > 0) {
                System.out.println("收到服务器的数据：" + new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
