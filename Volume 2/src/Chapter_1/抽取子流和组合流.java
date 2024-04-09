package Chapter_1;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 上午9:24
 * @description 抽取子流和组合流
 **/
public class 抽取子流和组合流 {

    static Random random = new Random();
    public static void main(String[] args) {
        limit方法();

        skip方法();

        takeWhile方法();

        dropWhile方法();

        concat方法();
    }

    private static void limit方法() {
        Stream.generate(Math::random)
                .limit(100)
                .forEach(s -> System.out.print(String.format("%.2f ", s) + " "));
        System.out.println();
    }

    private static void skip方法() {
        var list = List.of(2,3,4,5,6);
        list.stream().skip(2).forEach(it -> System.out.print(it + " "));
        System.out.println();
    }

    private static void takeWhile方法(){
        var list = List.of(2,3,4,5,6);
        list.stream().takeWhile(it -> it < 5).forEach(it -> System.out.print(it + " "));
        System.out.println();
    }
    private static void dropWhile方法(){
        var list = List.of(2,3,4,5,6);
        list.stream().dropWhile(it -> it > 5).forEach(it -> System.out.print(it + " "));
        System.out.println();
    }

    private static void concat方法(){
        var list = List.of(2,3,4,5,6);
        Stream<Integer> stream1 = list.stream().dropWhile(it -> it > 5);
        Stream<Integer> stream2 = list.stream().takeWhile(it -> it < 5);
        Stream.concat(stream1, stream2).forEach(it -> System.out.print(it + " "));
        System.out.println();
    }
}
