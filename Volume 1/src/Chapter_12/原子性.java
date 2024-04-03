package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 12:10
 * @description TODO
 **/
public class 原子性 {

    //private static LongAdder adder = new LongAdder();

    //private static AtomicInteger adder = new AtomicInteger(0);

    private static LongAccumulator adder = new LongAccumulator(Long::sum, 0);
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        var t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                adder.accumulate(1);
            }
        });
        var t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                adder.accumulate(1);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LocalDateTime end = LocalDateTime.now();
            System.out.println("耗时：" + ChronoUnit.MILLIS.between(now, end) + "毫秒");
            System.out.println(adder.get());
        }
    }
}
