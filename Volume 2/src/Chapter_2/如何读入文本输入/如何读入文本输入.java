package Chapter_2.如何读入文本输入;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午4:31
 * @description 如何读入文本输入
 **/
public class 如何读入文本输入 {
    public static void main(String[] args) throws IOException {
        读取文本();

        分隔符读取();

    }

    private static void 读取文本() throws IOException {
        String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\如何读入文本输入\\文件.txt";

        // 读取文件
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);

        System.out.println(content);

        // 按行读取文件
        List<String> strings = Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
        for (String string : strings) {
            System.out.println(string);
        }

        // 通过流读取
        Stream<String> lines = Files.lines(Path.of(path), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }

    private static void 分隔符读取() {
        // 创建一个字符串
        String input = "Hello, this is an example string.";

        // 创建一个扫描器
        Scanner scanner = new Scanner(input);

        // 设置分隔符为逗号
        scanner.useDelimiter(" ");

        Stream<String> tokens = scanner.tokens();


        // 使用扫描器读取字符串
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        // 关闭扫描器
        scanner.close();
    }


}
