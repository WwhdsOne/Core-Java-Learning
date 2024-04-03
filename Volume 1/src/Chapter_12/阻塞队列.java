package Chapter_12;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 16:58
 * @description 阻塞队列
 **/
public class 阻塞队列 {

    public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

    public static Random r = new Random();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for ( int i = 0; i < 10; i++ ) {
                boolean offer = queue.offer(i);
                if(offer) {
                    System.out.println("生产者生产了：" + i);
                }else{
                    System.out.println("队列已满");
                    System.out.println("生产者等待");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for ( int i = 0; i < 10; i++ ) {
                var poll = queue.poll();
                if(poll == null) {
                    System.out.println("队列为空");
                    System.out.println("消费者等待");
                } else {
                    System.out.println("消费者消费了：" + poll);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
