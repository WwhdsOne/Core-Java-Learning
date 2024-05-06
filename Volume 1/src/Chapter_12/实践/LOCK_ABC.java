package Chapter_12.实践;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/6 下午4:29
 * @description 三个线程交替打印ABC
 **/
public class LOCK_ABC {

    private int num;
    private static final ReentrantLock lock = new ReentrantLock();

    private void printABC(int targetNum) {
        for ( int i = 0; i < 10; ) {
            lock.lock();
            if ( num % 3 == targetNum ) {
                System.out.print(Thread.currentThread().getName());
                i++;
                num++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LOCK_ABC lock_abc = new LOCK_ABC();
        lock_abc.num = 0;
        new Thread(() -> lock_abc.printABC(0), "A").start();
        new Thread(() -> lock_abc.printABC(1), "B").start();
        new Thread(() -> lock_abc.printABC(2), "C").start();
    }
}
