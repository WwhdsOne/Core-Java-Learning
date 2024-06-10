package Chapter_12.实践;

//交替打印ABC
class Wait_Notify_ACB {

    private int num;
    private static final Object LOCK = new Object();

    private void printABC(int targetNum) {
        for ( int i = 0; i < 10; i++ ) {
            synchronized (LOCK) {
                // 使用while循环而不是if，以处理虚假唤醒的情况
                // 当线程被唤醒并重新获得锁后，它应该再次检查等待条件是否满足
                // 这是因为在多线程环境中，线程可能会因为所谓的"虚假唤醒"而被唤醒，或者在等待期间，其他线程可能已经改变了条件。
                // 如果使用if，那么在这些情况下，线程可能会继续执行，即使条件不再满足。
                while ( num % 3 != targetNum ) {
                    try {
                        // 当条件不满足时，线程将等待
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 当条件满足时，线程将继续执行
                num++;
                System.out.print(Thread.currentThread().getName());
                // 唤醒在此锁上等待的所有线程
                LOCK.notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        Wait_Notify_ACB wait_notify_acb = new Wait_Notify_ACB();
        new Thread(() -> wait_notify_acb.printABC(0), "A").start();
        new Thread(() -> wait_notify_acb.printABC(1), "B").start();
        new Thread(() -> wait_notify_acb.printABC(2), "C").start();
    }
}
