package Chapter_4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/15 下午7:37
 * @description 可中断套接字
 **/
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class 可中断套接字 {
    public static void main(String[] args) {
        try {
            // 打开一个SocketChannel并连接到指定的服务器
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 23333));

            // 发送一条消息到服务器
            String message = "Hello, Server!";
            ByteBuffer buffer = ByteBuffer.allocate(64);
            buffer.clear();
            buffer.put(message.getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            Thread.sleep(2000);
            // 关闭SocketChannel
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
