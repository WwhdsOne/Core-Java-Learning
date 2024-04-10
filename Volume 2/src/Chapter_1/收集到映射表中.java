package Chapter_1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/10 下午12:46
 * @description 收集到映射表中
 **/
public class 收集到映射表中 {
    public static void main(String[] args) {
        Person流转映射表();

        Person流转映射表_重复键();

        语言流转映射表_重复键_合并();


    }

    private static void Person流转映射表() {
        Stream<Person> personStream = Stream.of(new Person(1L, "张三"), new Person(2L, "李四"));
        Map<Long, Person> collect = personStream
                .collect(Collectors.toMap(Person::id, Function.identity()));
    }

    private static void Person流转映射表_重复键() {
        Stream<Person> personStream = Stream.of(new Person(1L, "张三"), new Person(1L, "李四"));
        Map<Long, Person> collect = personStream
                .collect(Collectors.toMap(Person::id, Function.identity(), (oldValue, newValue) -> oldValue));
    }

    private static void 语言流转映射表_重复键_合并() {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> collect = availableLocales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Set.of(l.getDisplayLanguage()),
                        (oldValue, newValue) -> {
                            Set<String> union = new HashSet<>(oldValue);
                            union.addAll(newValue);
                            return union;
                        }
                ));
        System.out.println(collect);
    }

    private static void 获取TreeMap(){
        Stream<Person> personStream = Stream.of(new Person(1L, "张三"), new Person(2L, "李四"));
        TreeMap<Long, Person> collect = personStream
                .collect(Collectors.toMap(Person::id, Function.identity(), (oldValue, newValue) -> oldValue, TreeMap::new));
    }
}

class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }
}


