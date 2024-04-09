package Chapter_1;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 上午8:30
 * @description 流的创建
 **/
public class 流的创建 {
    public static void main(String[] args) {
        ofNullable方法();
    }

    private static void toList方法(){
        // 生成一个包含一个元素的流
        Stream<Object> stream = Stream.of(1,2,3,4,5);
        List<Object> list = stream.toList();
        System.out.println(list);
    }

    private static void ofNullable方法(){
        Object obj = new Object();
        // 生成一个包含一个元素的流
        Stream<Object> stream1 = Stream.ofNullable(obj);
        stream1.forEach(System.out::println);
        // 生成一个空流
        obj = null;
        Stream<Object> stream2 = Stream.ofNullable(obj);
        stream2.forEach(System.out::println);
    }

    private static void iterate创建等差数列(){
        // 生成一个等差数列
        Stream.iterate(0, n ->n.compareTo(10) < 0,n -> n + 2)
                .forEach(System.out::println);
    }

    private static void 创建流(){
        var list = List.of(1, 2, 3, 4, 5);
        // 1. 由数值直接构建流
        var stream = Stream.of(1, 2, 3, 4, 5);
        // 2. 由数组构建流
        var stream1 = Stream.of(new int[]{1, 2, 3, 4, 5});
        // 3. 由集合构建流
        var stream3 = list.stream();
        var stream4 = list.parallelStream();
        // 4. 由函数生成流
        var stream5 = Stream.generate(Math::random);
    }
}
