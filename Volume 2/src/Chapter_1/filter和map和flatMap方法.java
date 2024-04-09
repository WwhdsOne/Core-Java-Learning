package Chapter_1;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 上午8:50
 * @description filter和map和flatMap方法
 **/
public class filter和map和flatMap方法 {

    private static final String string = "Hello,🌏";

    public static void main(String[] args) {
        filter方法();
        map方法();
        flatMap方法();
        Stream<String> stringStream = codePoints示例1(string);
        stringStream.forEach(System.out::println);
        mapMulti方法();
    }


    private static Stream<String> codePoints示例1(String str) {
        return str.codePoints().mapToObj(it -> new String(new int[]{it}, 0, 1));
    }

    private static void filter方法() {
        var list = List.of(1, 2, 3, 4, 5);
        // 过滤出偶数
        list.stream().filter(it -> it % 2 == 0).forEach(System.out::println);
    }

    private static void map方法() {
        var list = List.of(1, 2, 3, 4, 5);
        // 将每个元素乘以2
        list.stream().map(it -> it * 2).forEach(System.out::println);
    }

    private static void flatMap方法() {
        var list = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        // 将多个List合并成一个List
        list.stream().flatMap(List::stream).forEach(System.out::println);
    }

    private static void mapMulti方法() {
        var list = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        // 将每个List的元素乘以2
        list.stream()
                .mapMulti((it, consumer) -> it.forEach(e -> consumer.accept(e * 2)))
                .forEach(System.out::println);
    }
}
