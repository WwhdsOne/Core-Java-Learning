package Chapter_12;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/4 15:52
 * @description 可完成Future
 **/
public class 可完成Future {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);
    public static void main(String[] args) {
        var future = new CompletableFuture<Integer>();
        executorService.execute(() -> {
            try {
                future.complete(workSmart());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                future.complete(workHard());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.thenAccept(System.out::println);
        executorService.shutdown();
    }

    public static int workSmart() throws InterruptedException {
        Thread.sleep(1000);
        return 1;
    }

    public static int workHard() throws InterruptedException {
        Thread.sleep(2000);
        return 1;
    }

    public static CompletableFuture<String> getFuture() {
        return CompletableFuture.supplyAsync(() -> "Hello", executorService);
    }
}
