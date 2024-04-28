package Chapter_2.组合输入输出流过滤器;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午1:50
 * @description 产生数据
 **/
public class 产生数据 {
    public static void main(String[] args) throws FileNotFoundException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream("D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\组合输入输出流过滤器\\文件.txt"))) {
            for (int i = 0; i < 5; i++) {
                dataOutputStream.writeInt(i + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
