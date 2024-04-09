package Chapter_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 上午10:16
 * @description 其他流转换
 **/
public class 其他流转换 {

    public static void main(String[] args) {
        distinct方法();

        sorted方法();

        peek方法();
    }

    private static void distinct方法(){
        // 去重
        var list = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        list.stream().distinct().forEach(it -> System.out.print(it + " "));
        System.out.println();
    }

    private static void sorted方法(){
        var list = List.of("233","123","456","78239","123","Wwh","Wwh","Tom","LiHUa","LOLOLOLO");
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(it -> System.out.print(it + " "));
        System.out.println();
        list.stream().sorted(String::compareTo).forEach(it -> System.out.print(it + " "));
        System.out.println();
    }

    private static void peek方法(){
        // peek方法用于调试
        Stream.iterate(1, it -> it + 1)
                .peek(it -> System.out.print(it + " "))
                .limit(10)
                .count();
        System.out.println();
    }


}
