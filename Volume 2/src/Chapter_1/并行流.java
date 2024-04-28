package Chapter_1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/11 上午8:12
 * @description 并行流
 **/
public class 并行流 {

    private static Random random = new Random();
    public static void main(String[] args) {
        错误的并行流();

        正确的并行流();

        有序流();

        无序加速并行处理();

        合并映射表();
    }

    private static void 错误的并行流(){
        int[] value = new int[10];
        var list = Stream.generate(() -> random.nextInt(10)).limit(5000).toList();
        list.parallelStream().forEach(it -> {
            value[it]++;
        });
        System.out.println(Arrays.stream(value).sum()); // 不一定输出5000
    }

    private static void 正确的并行流(){
        int[] value = new int[10];
        int sum = 0;
        var list = Stream.generate(() -> random.nextInt(10)).limit(5000).toList();
        Map<Integer, Long> result = list.parallelStream().collect(Collectors.groupingBy(it -> it, counting()));
        long collect = result.values().stream().mapToLong(Long::valueOf).sum();
        System.out.println(collect);
    }

    private static void 有序流(){
        IntStream intStream = IntStream.rangeClosed(0, 10000);
        int sum = intStream.parallel().sum();
        System.out.println(sum); // 输出50005000
    }

    private static void 无序加速并行处理(){
        var list = Stream.generate(() -> random.nextInt(50)).limit(5000000).sorted().toList();
        long start = System.nanoTime();
        Stream<Integer> distinct = list.stream().unordered().distinct();
        long end = System.nanoTime();
        System.out.println("耗时：" + (end - start)/1000 + " 毫秒");
    }

    private static void 合并映射表(){
        var list = Stream.generate(() -> random.nextInt(50)).limit(5000000).sorted().toList();
        ConcurrentMap<Integer, Long> collect = list.stream().collect(Collectors.groupingByConcurrent(Function.identity(), counting()));
        System.out.println(collect);
    }
}
