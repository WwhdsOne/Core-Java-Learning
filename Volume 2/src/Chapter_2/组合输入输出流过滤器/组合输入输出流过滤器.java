package Chapter_2.组合输入输出流过滤器;

import java.io.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午1:09
 * @description 输入流
 **/
public class 组合输入输出流过滤器 {
    public static void main(String[] args) throws IOException {
        //嵌套过滤器读取文件();

        中介输入流读取文件();
    }

    private static void 中介输入流读取文件() throws FileNotFoundException {
        try {
            // 创建一个FileInputStream
            FileInputStream fis = new FileInputStream("D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\组合输入输出流过滤器\\文件.txt");

            // 使用BufferedInputStream来提高读取效率
            BufferedInputStream bis = new BufferedInputStream(fis);

            // 使用PushbackInputStream来回退一个字节
            PushbackInputStream pis = new PushbackInputStream(bis);

            // 使用DataInputStream来读取基本数据类型
            DataInputStream dis = new DataInputStream(bis);

            while ( dis.available() > 0) {
                // 读取一个整数
                int i = dis.readInt();
                System.out.println("读取的整数: " + i);
                if(i == 3) {
                    // 回退一个字节
                    pis.unread(i);
                    // 再次读取
                    i = pis.read();
                    System.out.println("再次读取的整数: " + i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void 嵌套过滤器读取文件() throws IOException{
        try {
            // 创建一个FileInputStream
            FileInputStream fis = new FileInputStream("D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\组合输入输出流过滤器\\文件.txt");

            // 使用BufferedInputStream来提高读取效率
            BufferedInputStream bis = new BufferedInputStream(fis);

            // 使用DataInputStream来读取基本数据类型
            DataInputStream dis = new DataInputStream(bis);

            // 读取数据
            while(dis.available() > 0) {
                // 读取一个整数
                int i = dis.readInt();
                System.out.println("读取的整数: " + i);
            }

            // 关闭流
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
