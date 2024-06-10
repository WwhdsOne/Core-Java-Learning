package Chapter_12.实践;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/29 下午4:33
 * @description
 **/
public class CountDownLatch实践 {

    private static CountDownLatch countDownLatch = new CountDownLatch(16);

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
        LocalDateTime begin = LocalDateTime.now();
        for(int i=0;i<16;i++)executorService.execute(() ->{
            try {
                Thread.sleep(1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            countDownLatch.await();  // 阻塞主线程，直到所有子线程完成任务
            LocalDateTime end = LocalDateTime.now();
            System.out.println("耗时:" + ChronoUnit.MILLIS.between(begin,end) + "ms");
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
