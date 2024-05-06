package Chapter_12.实践;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/6 下午3:33
 * @description 交替打印奇偶数
 **/
public class 交替打印奇偶数 {
    private final Object monitor = new Object();
    private volatile int count;

    交替打印奇偶数(int initCount) {
        this.count = initCount;
    }

    private void printOddEven() {

        synchronized (monitor) {
            // 使用while循环来检查条件，当count小于10时，线程将继续执行
            while ( count < 10 ) {
                try {
                    // 打印当前线程的名称和计数器的值
                    System.out.print(Thread.currentThread().getName() + "：" + (++count));
                    // 唤醒在此锁上等待的所有线程
                    monitor.notifyAll();
                    // 使当前线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法
                    monitor.wait();
                } catch (InterruptedException e) {
                    // 打印中断异常的堆栈跟踪
                    e.printStackTrace();
                }
            }
            // 当count达到10后，while循环不再执行，但可能还有一些线程在等待
            // 所以我们需要再次调用notifyAll()方法，确保所有等待的线程都被唤醒，防止主线程不能退出
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        交替打印奇偶数 waitNotifyOddEven = new 交替打印奇偶数(1);
        new Thread(waitNotifyOddEven::printOddEven, "odd").start();
        Thread.sleep(10); //为了保证线程odd先拿到锁
        new Thread(waitNotifyOddEven::printOddEven, "even").start();
    }
}
