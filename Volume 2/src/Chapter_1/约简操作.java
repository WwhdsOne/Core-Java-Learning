package Chapter_1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/10 下午3:46
 * @description 约简操作
 **/
public class 约简操作 {

    private static Random random = new Random();
    public static void main(String[] args) {
        简单reduce方法();

        指定幺元值reduce方法();

        并行流reduce();
    }

    private static void 简单reduce方法(){
        List<Integer> list = Stream.generate(() -> random.nextInt(15)).limit(30).toList();
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }

    private static void 指定幺元值reduce方法(){
        List<Integer> list = Stream.generate(() -> random.nextInt(15)).limit(30).toList();
        Integer result = list.stream().reduce(0,Integer::sum);
        System.out.println(result);
    }

    private static void 并行流reduce(){
        LocalDateTime start = LocalDateTime.now();
        Stream<Long> limit = Stream.generate(() -> random.nextLong(1000000000)).limit(100000000).parallel();
        Long result = limit.reduce(0L,Long::sum,Long::sum);
        System.out.println(result);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时:" + ChronoUnit.MILLIS.between(start,end));
    }
}
