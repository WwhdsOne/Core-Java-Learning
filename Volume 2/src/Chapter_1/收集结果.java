package Chapter_1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午4:56
 * @description 收集结果
 **/
public class 收集结果 {

    private static List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    public static void main(String[] args) {
        iterator方法();

        forEach方法();

        collect方法();
    }

    private static void iterator方法(){
        Stream<Integer> stream = list.stream();
        Iterator<Integer> iterator = stream.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    private static void forEach方法(){
        Stream<Integer> stream = list.stream();
        stream.forEach(it -> System.out.print(it * 2 + " "));
        System.out.println();
    }

    private static void toArray方法(){
        Stream<Integer> stream = list.stream();
        Object[] objects = stream.toArray();
        for (Object object : objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

    private static void collect方法(){
        Stream<Integer> stream = list.stream();
        TreeSet<Integer> result1 = stream.collect(Collectors.toCollection(TreeSet::new)); // 收集结果转换为TreeSet
        stream = list.stream();
        String result2 = stream
                .map(String::valueOf)
                .collect(Collectors.joining(", ")); // 收集结果转换为字符串并且中间有逗号
        stream = list.stream();
        IntSummaryStatistics result3 = stream
                .collect(Collectors.summarizingInt(Integer::intValue));// 收集结果转换为统计结果
        System.out.println(result3);
    }
}
