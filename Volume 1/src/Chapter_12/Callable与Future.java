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

        Callable<Integer> noException = () -> {
            Thread.sleep(1000);
            return 1;
        };

        Callable<Integer> exception = () -> {
            Thread.sleep(1000);
            throw new RuntimeException("抛出异常");
        };

        FutureTask<Integer> future1 = new FutureTask<>(noException);

        FutureTask<Integer> future2 = new FutureTask<>(exception);

        executorService.submit(future1);

        executorService.execute(future2); // 由于future2抛出了异常，所以在这里会抛出异常

        System.out.println("任务已经开始咯");

        var result = future1.get();

        System.out.println("result = " + result);
        System.out.println("任务已经结束咯");

        executorService.shutdown();
    }
}
