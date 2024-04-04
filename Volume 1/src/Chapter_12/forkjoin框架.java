package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/4 11:49
 * @description forkjoin基础使用
 **/
public class forkjoin框架 {

    private static final int Size = 100000000;
    private static final Random r = new Random();

    public static void main(String[] args) {
        var arr = new int[Size];
        for ( int i = 0; i < Size; i++ ) {
            arr[i] = r.nextInt(Size);
        }
        int limit = r.nextInt(Size);
        System.out.println("需要大于的值：" + limit);
        Counter counter = new Counter(arr,0,arr.length,i -> i > limit);
        var pool = new ForkJoinPool();
        LocalDateTime begin = LocalDateTime.now();
        pool.invoke(counter);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin,end) + "毫秒");
        System.out.println("大于" + limit + "的值有：" + counter.join() + "个");
    }
}

class Counter extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 1000;
    private final int[] values;
    private final int from;
    private final int to;

    private DoublePredicate filter;

    public Counter(int[] values, int from, int to, DoublePredicate filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if ( to - from < THRESHOLD ) {
            int count = 0;
            for ( int i = from; i < to; i++ ) {
                if ( filter.test(values[i]) ) {
                    count++;
                }
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            var first = new Counter(values,from,mid,filter);
            var second = new Counter(values,mid,to,filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}
