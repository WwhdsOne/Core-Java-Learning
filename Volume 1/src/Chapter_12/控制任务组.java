package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/3 22:34
 * @description TODO
 **/
public class 控制任务组 {

    private static final Random r = new Random();
    private static final ExecutorService executor = Executors.newFixedThreadPool(8);
    public static void main(String[] args) throws InterruptedException {
        ExecutorCompletionService队列();
    }

    public static void invokeAll方法() throws InterruptedException {
        List<Callable<Integer>> list = new ArrayList<>();
        LocalDateTime begin = LocalDateTime.now();
        for(int i=0;i<32;i++){
            Callable<Integer> callable = () -> {
                Thread.sleep(1000);
                return 1;
            };
            list.add(callable);
        }
        // 检查所有任务是否完成
        List<Future<Integer>> futures = executor.invokeAll(list);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin,end) + "毫秒");
        executor.shutdown();  // 不再接收新任务，等待所有已提交任务执行完成后关闭
    }

    public static void invokeAny方法() throws ExecutionException, InterruptedException {
        List<Callable<Long>> list = new ArrayList<>();
        for ( int i = 0; i < 8; i++ ) {
            var l = r.nextLong(1000,2000);
            System.out.println("任务" + i + "耗时：" + l + "毫秒");
            Callable<Long> callable = () -> {
                Thread.sleep(l);
                return l;
            };
            list.add(callable);
        }
        Long l = executor.invokeAny(list);
        executor.shutdownNow();
        System.out.println("最快的任务耗时：" + l + "毫秒");
    }

    public static void ExecutorCompletionService队列() {
        var service = new ExecutorCompletionService<Long>(executor);
        for ( int i = 0; i < 8; i++ ) {
            var l = r.nextLong(1000,2000);
            Callable<Long> callable = () -> {
                Thread.sleep(l);
                return l;
            };
            service.submit(callable);
        }
        for ( int i = 0; i < 8; i++ ) {
            try {
                Future<Long> future = service.take();
                System.out.println("任务" + i + "耗时：" + future.get() + "毫秒");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        }
    }
}
