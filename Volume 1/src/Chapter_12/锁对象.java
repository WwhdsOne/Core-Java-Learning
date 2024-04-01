package Chapter_12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 17:23
 * @description 锁对象
 **/
public class 锁对象 {
    private static int sharedVariable = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for ( int i = 0; i < 1000000; i++ ) {
                plus();
            }
        });

        Thread thread2 = new Thread(() -> {
            for ( int i = 0; i < 1000000; i++ ) {
                plus();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value of shared variable: " + sharedVariable);
    }

//    private static void plus(){
//        reentrantLock.lock();
//        try{
//            sharedVariable++;
//        } finally {
//            reentrantLock.unlock();
//        }
//    }

    private static synchronized void plus(){
        sharedVariable++;
    }
}
