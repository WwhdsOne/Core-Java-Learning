package Chapter_2.文本输入与输出;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午2:28
 * @description 文本输入与输出
 **/
public class 文本输入与输出 {
    public static void main(String[] args) {
        InputStreamReader类();
    }
    private static void InputStreamReader类(){
        // 创建一个InputStreamReader
        InputStreamReader isr = new InputStreamReader(System.in);
        // 使用BufferedReader来读取一行文本
        BufferedReader br = new BufferedReader(isr);

        System.out.println("请输入一行文本：");

        try {
            // 读取一行文本
            String line = br.readLine();
            System.out.println("你输入的文本是：" + line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
