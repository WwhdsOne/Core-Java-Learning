package Chapter_12;

import java.util.concurrent.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/3 21:12
 * @description
 **/
public class Callable与Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return 1;
        };

        FutureTask<Integer> future = new FutureTask<>(callable);
        executorService.submit(future);


        System.out.println("任务已经开始咯");

        var result = future.get();

        System.out.println("result = " + result);
        System.out.println("任务已经结束咯");

        executorService.shutdown();
    }
}
