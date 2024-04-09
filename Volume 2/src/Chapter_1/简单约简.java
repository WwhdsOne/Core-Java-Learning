package Chapter_1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午3:08
 * @description 简单约简
 **/
public class 简单约简 {

    private static Random random = new Random();
    public static void main(String[] args) {
        max和min();

        findFirst方法();

        findAny方法();

        anyMatch方法();
    }

    private static void max和min(){
        var list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.orElse(0));
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.orElse(0));
    }

    private static void findFirst方法(){
        var list = List.of("wwh", "Tom", "LiHua", "Wwh", "Wwh", "Tom", "Tom", "Tom","MC");
        Optional<String> first = list.stream().filter(it -> it.length() > 3).findFirst();
        System.out.println(first.orElse("Not Found"));
    }

    private static void findAny方法(){
        var list = List.of("wwh", "Tom", "LiHua", "Wwh", "Wwh", "Tom", "Tom", "Tom","MC");
        Optional<String> any = list.stream().parallel().filter(it -> it.length() < 3).findAny();
        System.out.println(any.orElse("Not Found"));
    }

    private static void anyMatch方法(){
        var array = Stream.generate(() -> random.nextInt(100))
                .limit(100000000).toArray(Integer[]::new);
        LocalDateTime start = LocalDateTime.now();
        boolean b = Arrays.stream(array).anyMatch(it -> it.equals(99999999));
        LocalDateTime end = LocalDateTime.now();
        System.out.println("99999999 " + (b ? "存在于数组中" : "不存在于数组中") +
                " 耗时：" + ChronoUnit.MILLIS.between(start, end) + "ms");
        start = LocalDateTime.now();
        b = Arrays.stream(array).parallel().anyMatch(it -> it.equals(99999999));
        end = LocalDateTime.now();
        System.out.println("99999999 " + (b ? "存在于数组中" : "不存在于数组中") +
                " 耗时：" + ChronoUnit.MILLIS.between(start, end) + "ms");
    }
}
