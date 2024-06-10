package Chapter_2.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReadExample {

    private static String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_2\\NIO\\文件.txt";
    public static void main(String[] args) {
        write();
    }

    private static void read(){
        try {
            RandomAccessFile reader = new RandomAccessFile(path, "r");
            FileChannel channel = reader.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(){
        try {
            RandomAccessFile writer = new RandomAccessFile(path, "rw");
            FileChannel channel = writer.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello, World!".getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
