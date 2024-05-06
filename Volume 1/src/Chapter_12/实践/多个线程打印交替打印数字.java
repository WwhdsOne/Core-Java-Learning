package Chapter_12.实践;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/6 下午3:39
 * @description 多个线程打印交替打印数字
 **/
public class 多个线程打印交替打印数字 {
    // 监视器
    private final Object monitor = new Object();
    // 计数器
    private volatile int count;
    // 结束值
    private final int end;
    // 线程数
    private final int ThreadCount;

    public 多个线程打印交替打印数字(int count, int end, int ThreadCount) {
        this.count = count;
        this.end = end;
        this.ThreadCount = ThreadCount;
    }

    private void printNumber(int targetNum) {
        // 无限循环，直到满足退出条件
        while ( true ) {
            // 同步块，确保每次只有一个线程进入
            synchronized (monitor) {
                // 当count与ThreadCount的余数不等于目标数时，线程进入等待状态
                while ( count % ThreadCount != targetNum ) {
                    // 如果count大于end，跳出循环
                    if ( count > end ) break;
                    try {
                        // 当前线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法
                        monitor.wait();
                    } catch (InterruptedException e) {
                        // 打印中断异常的堆栈跟踪
                        e.printStackTrace();
                    }
                }
                // 如果count大于end，跳出循环
                if ( count > end ) break;
                // 打印当前线程的名称和计数器的值
                System.out.println(Thread.currentThread().getName() + " " + (count++));
                // 唤醒在此锁上等待的所有线程
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int end = 100;
        int count = 1;
        int ThreadCount = 5;
        多个线程打印交替打印数字 t = new 多个线程打印交替打印数字(count, end, ThreadCount);
        for ( int i = 0; i < ThreadCount; i++ ) {
            int finalI = i;
            // 创建线程
            new Thread(() -> t.printNumber((finalI + 1) % ThreadCount),
                    "线程" + (i + 1)).start();
            Thread.sleep(10);
        }
    }
}
