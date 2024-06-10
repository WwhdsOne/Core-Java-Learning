package Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/13 下午3:26
 * @description 去重效率比较
 **/
public class 去重比较 {
    private static Random random = new Random();
    public static void main(String[] args) {
        List<Integer> list = IntStream.generate(random::nextInt).limit(1000000).boxed().toList();
        LocalDateTime begin = LocalDateTime.now();
        List<Integer> list3 = list.parallelStream().distinct().toList();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("流去重:" + ChronoUnit.MILLIS.between(begin,end));
        begin = LocalDateTime.now();
        List<Integer> list4 = new ArrayList<>(new HashSet<>(list));
        end = LocalDateTime.now();
        System.out.println("set去重:" + ChronoUnit.MILLIS.between(begin,end));
    }
}
