package Chapter_12;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 17:46
 * @description 锁嵌套
 **/
public class 锁嵌套 {

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println("外层锁 HoldCount: " + lock.getHoldCount());
            lock.lock();
            try {
                System.out.println("内层锁 HoldCount: " + lock.getHoldCount());
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
