package Chapter_12.实践;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/6 下午4:41
 * @description Lock_Condition_ABC
 **/
public class Lock_Condition_ABC {
    private int num;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    private void printABC(int targetNum, Condition currentThread, Condition nextThread) {
        for ( int i = 0; i < 10; ) {
            lock.lock();
            while ( num % 3 != targetNum ) {
                try {
                    currentThread.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print(Thread.currentThread().getName());
            i++;
            num++;
            nextThread.signal();
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Lock_Condition_ABC lock_condition_abc = new Lock_Condition_ABC();
        new Thread(()->lock_condition_abc
                .printABC(0, lock_condition_abc.condition1, lock_condition_abc.condition2),"A").start();
        new Thread(()->lock_condition_abc
                .printABC(1, lock_condition_abc.condition2, lock_condition_abc.condition3),"B").start();
        new Thread(()->lock_condition_abc
                .printABC(2, lock_condition_abc.condition3, lock_condition_abc.condition1),"C").start();
    }
}
