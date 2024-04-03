package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 17:23
 * @description TODO
 **/
public class 并发散列的批操作 {
    public static void main(String[] args) {
        var map = new HashMap<Integer, Integer>();
        Set<String> set = newKeySet();
        for ( int i = 0; i < 15; i++ ) {
            map.put(i, i);
        }
        LocalDateTime begin = LocalDateTime.now();
        map.forEach((k, v) -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin,end) + "毫秒");
    }
}
