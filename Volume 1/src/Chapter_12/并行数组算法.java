package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 18:13
 * @description 并行数组算法
 **/
public class 并行数组算法 {
    public static void main(String[] args) {
        Random r = new Random();
        var arr = new Long[10000000];
        for ( int i = 0; i < 10000000; i++ ) {
            arr[i] = r.nextLong();
        }
        int i = 10;
        LocalDateTime begin = LocalDateTime.now();
        Arrays.parallelSort(arr);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin,end) + "毫秒");
    }
}
