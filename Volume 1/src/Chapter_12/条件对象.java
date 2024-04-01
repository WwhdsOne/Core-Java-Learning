package Chapter_12;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 17:56
 * @description 条件对象
 **/
public class 条件对象 {

    // 创建一个可重入锁
    private static ReentrantLock lock = new ReentrantLock();

    // 创建一个条件对象，用于线程间的协调
    private static Condition lessThan233 = lock.newCondition();

    // 定义一个共享变量，表示账户的余额
    private static double money = 0;

    // 定义一个共享变量，表示消费的次数
    private static int count = 0;

    public static void main(String[] args) {
        Random r = new Random();
        // 创建一个线程，用于存款
        Thread t1 = new Thread(() -> {
            for ( int i = 0; i < 10000; i++ ) {
                addMoney(r.nextDouble(5));
            }
        });
        // 创建一个线程，用于消费
        Thread t2 = new Thread(() -> {
            for ( int i = 0; i < 100; i++ ) {
                spend();
            }
        });
        // 启动两个线程
        t1.start();
        t2.start();
        try {
            // 等待两个线程都结束
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印最后的余额和消费次数
        System.out.println("余额: " + money);
        System.out.println("消费次数: " + count);
    }

    // 存款方法
    public static void addMoney(double money) {
        // 获取锁
        lock.lock();
        try {
            // 增加余额
            条件对象.money += money;
            System.out.println("存入: " + money + " 余额: " + 条件对象.money);
            // 如果余额大于等于233，唤醒所有等待的线程
            if ( 条件对象.money >= 233 ) {
                lessThan233.signalAll();
            }
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    // 消费方法
    public static void spend() {
        System.out.println("开始消费");
        // 获取锁
        lock.lock();
        try {
            // 如果余额小于233，就等待
            while ( money < 233 ) {
                lessThan233.await();
            }
            // 消费233元
            money -= 233;
            // 消费次数加1
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
