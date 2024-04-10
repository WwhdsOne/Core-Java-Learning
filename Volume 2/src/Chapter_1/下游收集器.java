package Chapter_1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/10 下午2:02
 * @description 下游收集器
 **/
public class 下游收集器 {
    public static void main(String[] args) {
        语言流转映射表_重复键_合并_使用groupingBy();

        语言流转映射表_统计元素个数();

        语言流转映射表_统计总和和平均();

        maxBy和minBy方法();

        collectionAndThen方法();

        mapping方法();

        flatMapping方法();

        summarizing方法();

        filtering方法();


    }

    private static void 语言流转映射表_重复键_合并_使用groupingBy() {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> collect = availableLocales.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        toSet()
                ));
        System.out.println(collect);
    }

    private static void 语言流转映射表_统计元素个数(){
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> collect = availableLocales.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.counting()
                ));
        System.out.println(collect);
    }

    private static void 语言流转映射表_统计总和和平均() {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String,Integer> collect = availableLocales.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        summingInt(l -> l.getLanguage().length())
                ));
        System.out.println(collect);
        availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Double> collect1 = availableLocales.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.averagingInt(l -> l.getLanguage().length())
                ));
        System.out.println(collect1);
    }

    private static void maxBy和minBy方法(){
        Stream<Student> studentStream = Stream.of(new Student("北京", "张三"), new Student("上海", "李四"));
        Map<String, Optional<Student>> collect = studentStream.
                collect(groupingBy(Student::getCity, maxBy(Comparator.comparing(Student::getName))));
        System.out.println(collect);
        studentStream = Stream.of(new Student("北京", "张三"), new Student("上海", "李四"));
        collect = studentStream.
                collect(groupingBy(Student::getCity, minBy(Comparator.comparing(Student::getName))));
        System.out.println(collect.get("北京").get().getName());
    }

    private static void collectionAndThen方法(){
        var list = Stream.generate(Math::random).limit(30).toList();
        Map<Character, Integer> collect = list.stream().collect(groupingBy(
                s -> String.valueOf(s + 0.5).charAt(0),
                collectingAndThen(toSet(), Set::size)
        ));
        System.out.println(collect);
    }

    private static void mapping方法(){
        var list = Stream.generate(Math::random).limit(30).toList();
        Map<Character, Set<Integer>> collect = list.stream().collect(
                groupingBy(
                        s -> String.valueOf(s + 0.5).charAt(0),
                        mapping(s -> String.valueOf(s + 0.5).length(), toSet())
                )
        );
        System.out.println(collect);
    }

    private static void flatMapping方法(){
        List<String> words = List.of("Hello", "World");
        Map<Integer, TreeSet<Character>> result = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.flatMapping(
                                word -> word.chars().mapToObj(c -> (char) c),
                                Collectors.toCollection(TreeSet::new)
                        )
                ));
        System.out.println(result);
    }

    private static void summarizing方法(){
        var list = Stream.generate(Math::random).limit(30).toList();
        Map<Character, DoubleSummaryStatistics> collect = list.stream().collect(groupingBy(
                s -> String.valueOf(s + 0.3).charAt(0),
                summarizingDouble(Double::valueOf)
        ));
        System.out.println(collect);
    }

    private static void filtering方法(){
        var list = Stream.generate(Math::random).limit(30).toList();
        Map<Character, DoubleSummaryStatistics> collect = list.stream().collect(groupingBy(
                s -> String.valueOf(s + 0.3).charAt(0),
                filtering(s -> s>0.5,summarizingDouble(Double::valueOf))
        ));
        System.out.println(collect);
    }
}

class Student {
    private String city;
    private String name;

    public Student(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}
