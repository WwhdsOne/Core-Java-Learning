package Chapter_12;

import java.util.concurrent.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/4 18:35
 * @description
 **/
public class 组合可完成Future {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1完成");
            return 1;
        },executorService);
        var future2 = future1.thenApplyAsync(i -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2完成");
            return i + 1;
        },executorService);
        future2.thenAccept(System.out::println);

        System.out.println("开始执行");
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
