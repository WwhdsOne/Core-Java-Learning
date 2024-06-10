package Chapter_12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/23 下午5:26
 * @description 线程池创建
 **/
public class 线程池创建 {

    private static final ThreadPoolExecutor threadPoolExecutor = new
        ThreadPoolExecutor(
                17, // 核心线程数：线程池中始终存活的线程数
                17, // 最大线程数：线程池中允许的最大线程数
                60, // 空闲线程的存活时间：超过核心线程数的空闲线程在多长时间内会被销毁
                TimeUnit.SECONDS, // 存活时间的单位：上述存活时间的单位，这里是秒
                new ArrayBlockingQueue<>(10), // 工作队列：用于存放待处理的任务，这里容量是10
                // 拒绝策略：当工作队列已满，且线程池中的线程数达到最大线程数时，新任务将在调用者的线程中运行。如果线程池已经关闭，新任务将被丢弃。
                new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) {
        for ( int i = 0; i < 100; i++ ) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
