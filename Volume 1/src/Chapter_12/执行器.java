package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/3 21:54
 * @description 执行器
 **/
public class 执行器 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        List<Future<Integer>> futures = new ArrayList<>();
        LocalDateTime begin = LocalDateTime.now();

        for(int i=0;i<32;i++){
            Callable<Integer> callable = () -> {
                Thread.sleep(1000);
                return 1;
            };
            Future<Integer> future = executor.submit(callable);
            futures.add(future);
        }

        // 检查所有任务是否完成
        for (Future<Integer> future : futures) {
            while (!future.isDone()) {
                // 等待任务完成
                Thread.sleep(100);  // 每100毫秒检查一次
            }
            System.out.println("任务完成");
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin,end) + "毫秒");

        executor.shutdown();  // 不再接收新任务，等待所有已提交任务执行完成后关闭
    }
}
