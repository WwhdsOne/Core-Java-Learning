package Chapter_12;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // 启动一个线程向队列中添加元素
        new Thread(() -> {
            try {
                System.out.println("Adding to queue...");
                queue.put(1); // 这个操作会阻塞，直到另一个线程从队列中取走这个元素
                System.out.println("Successfully added to queue.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // 等待2秒，让上面的线程先运行
        Thread.sleep(2000);

        // 从队列中取出元素
        System.out.println("Fetching from queue...");
        Integer num = queue.take(); // 这个操作会阻塞，直到另一个线程向队列中添加一个元素
        System.out.println("Fetched from queue: " + num);
    }
}
