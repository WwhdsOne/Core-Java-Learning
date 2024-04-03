package Chapter_12;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 19:37
 * @description 死锁
 **/
public class 死锁 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread 1: locked");
                Thread.sleep(1000);
                lock.lock(); // 尝试再次获取锁
                System.out.println("Thread 1: locked again");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1: unlocked");
                lock.unlock();
                System.out.println("Thread 1: unlocked again");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(500); // 等待线程1获取锁
                lock.lock(); // 尝试获取锁
                System.out.println("Thread 2: locked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}
