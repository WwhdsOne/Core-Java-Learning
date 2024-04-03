package Chapter_12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/3 21:12
 * @description
 **/
public class Callable与Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return 1;
        };
        var future = new FutureTask<>(callable);
        var t = new Thread(future);
        t.start();
        System.out.println("任务已经开始咯");
        var result = future.get();
        System.out.println("result = " + result);
        System.out.println("任务已经结束咯");
    }
}
