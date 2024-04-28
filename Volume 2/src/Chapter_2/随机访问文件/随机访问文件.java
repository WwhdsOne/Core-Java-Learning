package Chapter_2.随机访问文件;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午5:29
 * @description 随机访问文件
 **/
public class 随机访问文件 {
    public static void main(String[] args) {
        String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\随机访问文件\\文件.txt";
        try {
            RandomAccessFile randomAccessFile =
                    new RandomAccessFile(path, "r");
            long n = 3;
            randomAccessFile.seek(n * 4);
            int i = randomAccessFile.readInt();
            System.out.println(i);
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.length());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
