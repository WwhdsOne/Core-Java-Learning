package Chapter_2.如何写出文本输出;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午2:52
 * @description 如何写出文本输出
 **/
public class 如何写出文本输出 {
    public static void main(String[] args) throws FileNotFoundException {
        var out = new PrintWriter("D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\如何写出文本输出\\文件.txt");
        String name = "Wwh";
        int age = 20;
        double score = 99.5;
        out.println(name);
        out.print(age + " " + score);
        out.close();
    }
}
