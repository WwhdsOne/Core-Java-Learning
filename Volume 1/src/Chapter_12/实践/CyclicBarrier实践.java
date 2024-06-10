package Chapter_12.实践;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/29 下午7:59
 * @description CyclicBarrier实践
 **/
public class CyclicBarrier实践 {


    private static final int THREAD_COUNT = 5;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT, () -> {
        System.out.println("所有线程已经到达栅栏，继续执行");
    });

    public static void main(String[] args) {
        for ( int i = 0; i < THREAD_COUNT; i++ ) {
            new Thread(new Worker(i)).start();
        }
        List list = List.of(1,2,3,4,5);
        list.iterator()
    }

    static class Worker implements Runnable {
        private int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Integer sleepTime = (int) (Math.random() * 10000);
                System.out.println("线程 " + id + " 正在执行任务..." + "耗时：" + sleepTime + "ms");
                Thread.sleep(sleepTime);
                System.out.println("线程 " + id + " 完成任务，等待其他线程...");

                cyclicBarrier.await();

                System.out.println("所有线程都完成任务，线程 " + id + " 继续执行...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
